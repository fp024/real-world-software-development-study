package org.rwsd.study.controller;

import static org.rwsd.study.domain.ReportType.HTML;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.rwsd.study.domain.ReportType;
import org.rwsd.study.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MainController {

  private final MainService mainService;

  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping({"/", "/index", "/main"})
  public String mainGET(Model model) {
    model.addAttribute("reportType", HTML);
    return "main";
  }

  @PostMapping("/main")
  public String mainPOST(String csvFileName, ReportType reportType, Model model)
      throws IOException {
    LOGGER.info("fileName: {}", csvFileName);
    LOGGER.info("reportType: {}", reportType);

    String result = mainService.analyze(csvFileName, reportType);

    LOGGER.info("### result: {}", result);

    model.addAttribute("reportType", reportType);
    if (reportType == HTML) {
      model.addAttribute(
          "result",
          "data:text/html;base64,"
              + Base64.getEncoder().encodeToString(result.getBytes(StandardCharsets.UTF_8)));
    } else {
      model.addAttribute("result", result);
    }

    return "main";
  }
}
