package org.rwsd.study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.rwsd.study.domain.BankTransaction;
import org.rwsd.study.parser.BankStatementCSVParser;
import org.rwsd.study.parser.BankStatementParser;
import org.rwsd.study.util.CommonUtil;

/*
  예제 2-5: BankTransactionAnalyzerSimple의 첫번째 개선
*/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankTransactionAnalyzer01 {
  public static void main(String[] args) throws IOException {
    final BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();

    final Path path = CommonUtil.getFilePathFromResources(args[0]);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFrom(lines);

    System.out.println(
        "The total for all transactions is " + calculateTotalAmount(bankTransactions));

    System.out.println(
        "The transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY));
  }

  private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
    double total = 0d;
    for (BankTransaction bankTransaction : bankTransactions) {
      total += bankTransaction.getAmount();
    }
    return total;
  }

  public static List<BankTransaction> selectInMonth(
      final List<BankTransaction> bankTransactions, final Month month) {
    List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransaction.getDate().getMonth() == month) {
        bankTransactionsInMonth.add(bankTransaction);
      }
    }

    return bankTransactionsInMonth;
  }
}
