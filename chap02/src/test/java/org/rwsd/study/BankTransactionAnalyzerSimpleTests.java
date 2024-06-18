package org.rwsd.study;

import org.junit.jupiter.api.Test;

class BankTransactionAnalyzerSimpleTests {
  @Test
  void testMain() throws Exception {
    BankTransactionAnalyzerSimple.main(new String[] {"bank-data-simple.csv"});
  }
}
