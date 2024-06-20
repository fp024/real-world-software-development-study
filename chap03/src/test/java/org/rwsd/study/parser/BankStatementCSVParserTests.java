package org.rwsd.study.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.rwsd.study.domain.BankTransaction;

class BankStatementCSVParserTests {

  private BankStatementParser parser = new BankStatementCSVParser();

  @Test
  void shouldParseOneCorrectLine() {
    final String line = "30-01-2017,-50,Tesco";

    final BankTransaction result = parser.parseFrom(line);

    final BankTransaction expected =
        new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

    final double tolerance = 0.0d;

    assertEquals(expected.getDate(), result.getDate());
    assertEquals(expected.getAmount(), result.getAmount(), tolerance);
    assertEquals(expected.getDescription(), result.getDescription());
  }

  @Test
  void testParseLinesFrom() {

    List<BankTransaction> result =
        parser.parseLinesFrom(List.of("30-01-2017,-100,Deliveroo", "30-01-2017,-50,Tesco"));

    assertThat(result).hasSize(2);

    assertThat(result.get(0).getDate()) //
        .isEqualTo(LocalDate.of(2017, 1, 30));
    assertThat(result.get(0).getAmount()) //
        .isEqualTo(-100.0);
    assertThat(result.get(0).getDescription()) //
        .isEqualTo("Deliveroo");

    assertThat(result.get(1)) //
        .hasFieldOrPropertyWithValue("date", LocalDate.of(2017, 1, 30))
        .hasFieldOrPropertyWithValue("amount", -50.0)
        .hasFieldOrPropertyWithValue("description", "Tesco");
  }
}
