package org.rwsd.study.util;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtil {

  /** resources 경로의 파일을 로드 */
  public static Path getFilePathFromResources(String fileName) {
    URL resource = CommonUtil.class.getResource("/" + fileName);
    try {
      return Path.of(resource.toURI());
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
