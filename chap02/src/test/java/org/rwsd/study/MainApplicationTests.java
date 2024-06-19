package org.rwsd.study;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class MainApplicationTests {
  @Test
  void testMain() throws IOException {
    MainApplication.main(new String[] {"bank-data-simple.csv"});
  }
}
