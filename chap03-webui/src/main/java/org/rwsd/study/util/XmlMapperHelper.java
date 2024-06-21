package org.rwsd.study.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** Jackson ObjectMapper 헬퍼 클래스 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class XmlMapperHelper {
  public static XmlMapper xmlMapper() {
    return XmlMapperHolder.INSTANCE;
  }

  private static class XmlMapperHolder {
    private static final XmlMapper INSTANCE;

    static {
      XmlMapper xmlMapper = new XmlMapper();
      xmlMapper.registerModule(new JavaTimeModule());
      INSTANCE = xmlMapper;
    }
  }
}
