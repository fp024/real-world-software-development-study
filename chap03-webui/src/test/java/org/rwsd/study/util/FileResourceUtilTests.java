package org.rwsd.study.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class FileResourceUtilTests {

  @Test
  void getFilePathFromResources() throws FileNotFoundException {
    Path csvFile = FileResourceUtil.getFilePathFromResources("bank-data-simple.csv");
    assertThat(csvFile).isNotNull();
  }

  @Test
  void getFilePathFromResources_NoExists() {
    assertThatThrownBy(() -> FileResourceUtil.getFilePathFromResources("no-exist.csv"))
        .hasMessage("no-exist.csv")
        .isInstanceOf(FileNotFoundException.class);
  }
}
