package org.rwsd.study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.rwsd.study.util.CommonUtil;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankTransactionAnalyzerSimple {
  public static void main(String[] args) throws IOException {
    final Path path = CommonUtil.getFilePathFromResources(args[0]);
    final List<String> lines = Files.readAllLines(path);

    double total = 0d;

    final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    for (final String line : lines) {
      final String[] columns = line.split(",");
      final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

      if (date.getMonth() == Month.JANUARY) {
        final double amount = Double.parseDouble(columns[1]);
        total += amount;
      }
    }

    System.out.println("The total for all transactions in January is " + total);
  }
}
