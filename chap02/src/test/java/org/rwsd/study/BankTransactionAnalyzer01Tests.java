package org.rwsd.study;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class BankTransactionAnalyzer01Tests {
  @Test
  void testMain() throws IOException {
    BankTransactionAnalyzer01.main(new String[] {"bank-data-simple.csv"});
  }
}
