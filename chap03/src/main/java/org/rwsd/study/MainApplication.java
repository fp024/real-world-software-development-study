package org.rwsd.study;

import java.io.IOException;
import org.rwsd.study.parser.BankStatementCSVParser;
import org.rwsd.study.parser.BankStatementParser;

/*
 메인 응용 프로그램
*/
public class MainApplication {

  public static void main(String[] args) throws IOException {
    final BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();

    final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    bankTransactionAnalyzer.analyzer(args[0], bankStatementParser);
  }
}
