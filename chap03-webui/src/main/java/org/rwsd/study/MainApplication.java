package org.rwsd.study;

import java.io.IOException;
import org.rwsd.study.exporter.Exporter;
import org.rwsd.study.exporter.HtmlExporter;
import org.rwsd.study.exporter.JsonExporter;
import org.rwsd.study.parser.BankStatementCSVParser;
import org.rwsd.study.parser.BankStatementParser;

/*
 메인 응용 프로그램
*/
public class MainApplication {

  public static void main(String[] args) throws IOException {
    final BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();

    final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    System.out.println("### HTML Export ###");
    final Exporter htmlExporter = new HtmlExporter();
    bankTransactionAnalyzer.analyzer(args[0], bankStatementParser, htmlExporter);

    System.out.println("### JSON Export ###");
    final Exporter jsonExporter = new JsonExporter();
    bankTransactionAnalyzer.analyzer(args[0], bankStatementParser, jsonExporter);
  }
}
