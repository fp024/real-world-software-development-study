package org.rwsd.study.service;

import java.io.IOException;
import java.util.Map;
import org.rwsd.study.BankTransactionAnalyzer;
import org.rwsd.study.domain.ReportType;
import org.rwsd.study.exporter.Exporter;
import org.rwsd.study.parser.BankStatementParser;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  private final BankTransactionAnalyzer bankTransactionAnalyzer;

  private final BankStatementParser bankStatementParser;

  private final Map<ReportType, Exporter> exporterMap;

  public MainService(
      BankTransactionAnalyzer bankTransactionAnalyzer,
      BankStatementParser bankStatementParser,
      Map<ReportType, Exporter> exporterMap) {
    this.bankTransactionAnalyzer = bankTransactionAnalyzer;
    this.bankStatementParser = bankStatementParser;
    this.exporterMap = exporterMap;
  }

  public String analyze(String fileName, ReportType reportType) throws IOException {
    return bankTransactionAnalyzer.analyzer(
        fileName, bankStatementParser, exporterMap.get(reportType));
  }
}
