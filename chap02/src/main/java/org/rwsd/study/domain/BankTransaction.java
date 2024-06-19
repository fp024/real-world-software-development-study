package org.rwsd.study.domain;

import java.time.LocalDate;
import java.util.Objects;
import lombok.Getter;

@Getter
public class BankTransaction {
  private final LocalDate date;
  private final double amount;
  private final String description;

  public BankTransaction(LocalDate date, double amount, String description) {
    this.date = date;
    this.amount = amount;
    this.description = description;
  }

  @Override
  public String toString() {
    return "BankTransaction{"
        + "date="
        + date
        + ", amount="
        + amount
        + ", description='"
        + description
        + '\''
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BankTransaction that = (BankTransaction) o;
    return Double.compare(that.amount, amount) == 0
        && date.equals(that.date)
        && description.equals(that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, amount, description);
  }
}
