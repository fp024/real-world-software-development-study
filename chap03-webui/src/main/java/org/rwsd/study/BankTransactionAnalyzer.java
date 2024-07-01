package org.rwsd.study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.rwsd.study.domain.BankTransaction;
import org.rwsd.study.exporter.Exporter;
import org.rwsd.study.parser.BankStatementParser;
import org.rwsd.study.processor.BankTransactionProcessor;
import org.rwsd.study.util.FileResourceUtil;

public class BankTransactionAnalyzer {

  public String analyzer(
      String fileName, final BankStatementParser bankStatementParser, final Exporter exporter)
      throws IOException {

    final Path path = FileResourceUtil.getFilePathFromResources(fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

    final BankTransactionProcessor bankStatementProcessor =
        new BankTransactionProcessor(bankTransactions);

    return exporter.export(bankStatementProcessor.summarizeTransactions());
  }

  public void analyzerThenConsolePrint(
      String fileName, final BankStatementParser bankStatementParser, final Exporter exporter)
      throws IOException {

    System.out.println(this.analyzer(fileName, bankStatementParser, exporter));
  }
}
