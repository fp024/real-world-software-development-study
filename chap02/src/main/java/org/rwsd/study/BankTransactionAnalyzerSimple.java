package org.rwsd.study;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankTransactionAnalyzerSimple {
  public static void main(String[] args) throws IOException {
    final Path path = getCsvPath(args[0]);
    final List<String> lines = Files.readAllLines(path);

    double total = 0d;

    for (final String line : lines) {
      final String[] columns = line.split(",");
      final double amount = Double.parseDouble(columns[1]);
      total += amount;
    }
    System.out.println("The total for all transactions is " + total);
  }

  private static Path getCsvPath(String fileName) {
    URL resource = BankTransactionAnalyzerSimple.class.getResource("/" + fileName);
    try {
      return Path.of(resource.toURI());
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
