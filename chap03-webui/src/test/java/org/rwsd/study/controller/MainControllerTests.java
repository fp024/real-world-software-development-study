package org.rwsd.study.controller;

import static org.rwsd.study.domain.ReportType.HTML;
import static org.rwsd.study.domain.ReportType.JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.rwsd.study.config.BankTransactionAppRootConfig;
import org.rwsd.study.config.BankTransactionAppWebConfig;
import org.rwsd.study.domain.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringJUnitWebConfig(
    classes = {BankTransactionAppRootConfig.class, BankTransactionAppWebConfig.class})
class MainControllerTests {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext context;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void testMain_FirstAccess() throws Exception {
    mockMvc
        .perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attribute("csvFileName", "bank-data-simple.csv"))
        .andExpect(model().attribute("reportType", HTML))
        .andExpect(model().attributeDoesNotExist("result", "errorMessage"))
        .andExpect(view().name("main"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"HTML", "JSON", "XML"})
  void testMain_Analyze(String reportType) throws Exception {
    mockMvc
        .perform(
            get("/main")
                .queryParam("csvFileName", "bank-data-simple.csv") //
                .queryParam("reportType", reportType))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attribute("csvFileName", "bank-data-simple.csv"))
        .andExpect(model().attribute("reportType", ReportType.valueOf(reportType)))
        .andExpect(model().attributeDoesNotExist("errorMessage"))
        .andExpect(view().name("main"));
  }

  @Test
  void testMain_FileNotFound() throws Exception {
    var fileName = "no-exist.csv";

    mockMvc
        .perform(
            get("/main")
                .queryParam("csvFileName", fileName) //
                .queryParam("reportType", JSON.name()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().attribute("csvFileName", fileName))
        .andExpect(model().attribute("reportType", JSON))
        .andExpect(model().attribute("errorMessage", "💢 %s 파일이 존재하지 않습니다.".formatted(fileName)))
        .andExpect(model().attributeDoesNotExist("result"))
        .andExpect(view().name("main"));
  }
}
