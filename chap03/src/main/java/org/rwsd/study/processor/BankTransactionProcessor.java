package org.rwsd.study.processor;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.rwsd.study.domain.BankTransaction;
import org.rwsd.study.function.BankTransactionFilter;
import org.rwsd.study.function.BankTransactionSummarizer;

public class BankTransactionProcessor {

  private final List<BankTransaction> bankTransactions;

  public BankTransactionProcessor(List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
    double result = 0;
    for (BankTransaction bankTransaction : bankTransactions) {
      result = bankTransactionSummarizer.summarize(result, bankTransaction);
    }
    return result;
  }

  public double calculateTotalAmount() {
    return summarizeTransactions((acc, bankTransaction) -> acc + bankTransaction.getAmount());
  }

  public double calculateTotalInMonth(final Month month) {
    return summarizeTransactions(
        (acc, bankTransaction) ->
            bankTransaction.getDate().getMonth() == month
                ? acc + bankTransaction.getAmount()
                : acc);
  }

  public double calculateTotalForCategory(final String category) {
    return summarizeTransactions(
        (acc, bankTransaction) ->
            bankTransaction.getDescription().equals(category)
                ? acc + bankTransaction.getAmount()
                : acc);
  }

  public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
    return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
  }

  public List<BankTransaction> findTransactionsInMonth(final Month month) {
    return findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == month);
  }

  public List<BankTransaction> findTransactionsInMonthAndGreaterThenEqual(
      final Month month, final int amount) {
    return findTransactions(
        bankTransaction ->
            bankTransaction.getAmount() >= amount && bankTransaction.getDate().getMonth() == month);
  }

  public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
    final List<BankTransaction> result = new ArrayList<>();
    for (BankTransaction bankTransaction : bankTransactions) {
      if (bankTransactionFilter.test(bankTransaction)) {
        result.add(bankTransaction);
      }
    }
    return result;
  }
}
