package org.rwsd.study;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class BankTransactionAnalyzerSimple01Tests {
  @Test
  void testMain() throws IOException {
    BankTransactionAnalyzerSimple01.main(new String[] {"bank-data-simple.csv"});
  }
}
