package org.rwsd.study.parser;

import java.util.List;
import org.rwsd.study.domain.BankTransaction;

public interface BankStatementParser {
  BankTransaction parseFrom(String line);

  List<BankTransaction> parseLinesFrom(List<String> lines);
}
