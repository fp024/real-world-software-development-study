package org.rwsd.study.function;

import org.rwsd.study.domain.BankTransaction;

/** 예제 3-4. BankTransactionFilter 인터페이스 */
@FunctionalInterface
public interface BankTransactionFilter {
  boolean test(BankTransaction bankTransaction);
}
