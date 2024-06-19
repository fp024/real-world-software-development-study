package org.rwsd.study.parser;

import org.rwsd.study.domain.BankTransaction;

public class BankTransactionParser {

  public BankTransaction parseFromCSV(final String line) {
    // ...
    throw new UnsupportedOperationException();
  }

  public BankTransaction parseFromJSON(final String line) {
    // ... 💡 JSON은 line 별로 파싱을 하진 못하긴 할텐데...
    throw new UnsupportedOperationException();
  }

  public BankTransaction parseFromXML(final String line) {
    // ... 💡 XML은 line 별로 파싱을 하진 못하긴 할텐데...
    throw new UnsupportedOperationException();
  }
}
