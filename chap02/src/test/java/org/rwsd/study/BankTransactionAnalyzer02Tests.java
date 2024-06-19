package org.rwsd.study;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class BankTransactionAnalyzer02Tests {
  @Test
  void testMain() throws IOException {
    BankTransactionAnalyzer02.main(new String[] {"bank-data-simple.csv"});
  }
}
