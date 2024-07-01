package org.rwsd.study.service;

import java.io.IOException;
import org.rwsd.study.BankTransactionAnalyzer;
import org.rwsd.study.domain.ReportType;
import org.rwsd.study.parser.BankStatementParser;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  private final BankTransactionAnalyzer bankTransactionAnalyzer;

  private final BankStatementParser bankStatementParser;

  private final ApplicationContext applicationContext;

  public MainService(
      BankTransactionAnalyzer bankTransactionAnalyzer,
      BankStatementParser bankStatementParser,
      ApplicationContext applicationContext) {
    this.bankTransactionAnalyzer = bankTransactionAnalyzer;
    this.bankStatementParser = bankStatementParser;
    this.applicationContext = applicationContext;
  }

  public String analyze(String fileName, ReportType reportType) throws IOException {
    return bankTransactionAnalyzer.analyzer(
        fileName, bankStatementParser, applicationContext.getBean(reportType.getExporterClass()));
  }
}
