package org.rwsd.study.service;

import java.io.IOException;
import org.rwsd.study.BankTransactionAnalyzer;
import org.rwsd.study.domain.ReportType;
import org.rwsd.study.exporter.HtmlExporter;
import org.rwsd.study.exporter.JsonExporter;
import org.rwsd.study.exporter.XmlExporter;
import org.rwsd.study.parser.BankStatementParser;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  private final BankTransactionAnalyzer bankTransactionAnalyzer;

  private final BankStatementParser bankStatementParser;

  private final HtmlExporter htmlExporter;

  private final JsonExporter jsonExporter;

  private final XmlExporter xmlExporter;

  public MainService(
      BankTransactionAnalyzer bankTransactionAnalyzer,
      BankStatementParser bankStatementParser,
      HtmlExporter htmlExporter,
      JsonExporter jsonExporter,
      XmlExporter xmlExporter) {
    this.bankTransactionAnalyzer = bankTransactionAnalyzer;
    this.bankStatementParser = bankStatementParser;
    this.htmlExporter = htmlExporter;
    this.jsonExporter = jsonExporter;
    this.xmlExporter = xmlExporter;
  }

  public String analyze(String fileName, ReportType reportType) {
    try {
      return switch (reportType) {
        case HTML -> bankTransactionAnalyzer.analyzer(fileName, bankStatementParser, htmlExporter);
        case JSON -> bankTransactionAnalyzer.analyzer(fileName, bankStatementParser, jsonExporter);
        case XML -> bankTransactionAnalyzer.analyzer(fileName, bankStatementParser, xmlExporter);
      };

    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
