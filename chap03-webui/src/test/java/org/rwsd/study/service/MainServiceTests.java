package org.rwsd.study.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.rwsd.study.config.BankTransactionAppRootConfig;
import org.rwsd.study.domain.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = BankTransactionAppRootConfig.class)
class MainServiceTests {
  @Autowired private MainService mainService;

  @Test
  void analyze() throws IOException {
    String result = mainService.analyze("bank-data-simple.csv", ReportType.JSON);
    assertThat(result).isNotEmpty();
  }
}
