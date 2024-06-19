package org.rwsd.study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.rwsd.study.domain.BankTransaction;
import org.rwsd.study.parser.BankStatementCSVParser;
import org.rwsd.study.parser.BankStatementParser;
import org.rwsd.study.processor.BankStatementProcessor;
import org.rwsd.study.util.CommonUtil;

/*
  예제 2-8: BankTransactionAnalyzerSimple의 두번째 개선
  - BankStatementProcessor 클래스를 애용해 입출금 내역 목록 처리
*/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankTransactionAnalyzer02 {
  public static void main(String[] args) throws IOException {
    final BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();

    final Path path = CommonUtil.getFilePathFromResources(args[0]);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFrom(lines);

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
