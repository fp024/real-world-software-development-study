package org.rwsd.study.processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.rwsd.study.domain.BankTransaction;

@TestInstance(Lifecycle.PER_CLASS)
class BankStatementProcessorTests {

  private List<BankTransaction> bankTransactions;

  private BankStatementProcessor processor;

  @BeforeAll
  void init() {
    bankTransactions =
        List.of(
            new BankTransaction(LocalDate.of(2017, 1, 30), -100, "Deliveroo"),
            new BankTransaction(LocalDate.of(2017, 1, 30), -50, "Tesco"),
            new BankTransaction(LocalDate.of(2017, 2, 1), 6000, "Salary"),
            new BankTransaction(LocalDate.of(2017, 2, 2), 2000, "Royalties"),
            new BankTransaction(LocalDate.of(2017, 2, 2), -4000, "Rent"),
            new BankTransaction(LocalDate.of(2017, 2, 3), 3000, "Tesco"),
            new BankTransaction(LocalDate.of(2017, 2, 5), -30, "Cinema"));

    processor = new BankStatementProcessor(bankTransactions);
  }

  @Test
  void testCalculateTotalAmount() {
    assertThat(processor.calculateTotalAmount()) //
        .isEqualTo(6820);
  }

  @Test
  void testCalculateTotalForCategory() {
    assertThat(processor.calculateTotalForCategory("Tesco")) //
        .isEqualTo(2950);
  }

  @Test
  void testCalculateTotalInMonth() {
    assertThat(processor.calculateTotalInMonth(Month.FEBRUARY)) //
        .isEqualTo(6970);
  }
}
