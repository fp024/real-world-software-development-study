package org.rwsd.study.dao;

import java.time.LocalDate;
import org.rwsd.study.domain.BankTransaction;

public class BankTransactionDAO {

  public BankTransaction create(
      final LocalDate date, final double amount, final String description) {
    // ...
    throw new UnsupportedOperationException();
  }

  public BankTransaction read(final long id) {
    // ...
    throw new UnsupportedOperationException();
  }

  public BankTransaction update(final BankTransaction bankTransaction) {
    // ...
    throw new UnsupportedOperationException();
  }

  public void delete(final long id) {
    // ...
    throw new UnsupportedOperationException();
  }
}
