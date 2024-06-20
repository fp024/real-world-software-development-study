package org.rwsd.study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;
import org.rwsd.study.domain.BankTransaction;
import org.rwsd.study.parser.BankStatementParser;
import org.rwsd.study.processor.BankStatementProcessor;
import org.rwsd.study.util.CommonUtil;

/*
  예제 2-12 BankStatementAnalyzer에서 특정 파서와의 결합제거
*/
public class BankTransactionAnalyzer {

  public void analyzer(String fileName, final BankStatementParser bankStatementParser)
      throws IOException {

    final Path path = CommonUtil.getFilePathFromResources(fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

    final BankStatementProcessor bankStatementProcessor =
        new BankStatementProcessor(bankTransactions);

    collectSummary(bankStatementProcessor);
  }

  private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
    System.out.println(
        "The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());

    System.out.println(
        "The total for transactions in January is "
            + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

    System.out.println(
        "The total salary received is "
            + bankStatementProcessor.calculateTotalForCategory("Salary"));
  }
}
