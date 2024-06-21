package org.rwsd.study.function;

import java.time.Month;
import org.rwsd.study.domain.BankTransaction;

public class BankTransactionIsFebruaryAndExpensive implements BankTransactionFilter {

  @Override
  public boolean test(BankTransaction bankTransaction) {
    return bankTransaction.getDate().getMonth() == Month.FEBRUARY
        && bankTransaction.getAmount() >= 1_000;
  }
}
