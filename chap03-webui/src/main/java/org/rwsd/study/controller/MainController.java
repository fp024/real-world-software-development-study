package org.rwsd.study.controller;

import static org.rwsd.study.domain.ReportType.HTML;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.rwsd.study.domain.ReportType;
import org.rwsd.study.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  private final MainService mainService;

  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping(path = {"/", "/main"})
  public String main(String csvFileName, ReportType reportType, Model model) {
    if (reportType == null) {
      model.addAttribute("csvFileName", "bank-data-simple.csv");
      model.addAttribute("reportType", HTML);
      return "main";
    }

    model.addAttribute("csvFileName", csvFileName);
    model.addAttribute("reportType", reportType);

    try {
      String result = mainService.analyze(csvFileName, reportType);
      if (reportType == HTML) {
        model.addAttribute(
            "result",
            "data:text/html;base64,"
                + Base64.getEncoder().encodeToString(result.getBytes(StandardCharsets.UTF_8)));
      } else {
        model.addAttribute("result", result);
      }
    } catch (FileNotFoundException fe) {
      model.addAttribute("errorMessage", "💢 %s 파일이 존재하지 않습니다.".formatted(fe.getMessage()));
    } catch (IOException e) {
      model.addAttribute("errorMessage", "오류가 발생했습니다.");
    }
    return "main";
  }
}
