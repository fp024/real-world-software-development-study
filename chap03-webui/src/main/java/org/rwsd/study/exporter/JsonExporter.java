package org.rwsd.study.exporter;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.rwsd.study.domain.SummaryStatistics;
import org.rwsd.study.util.ObjectMapperHelper;

public class JsonExporter implements Exporter {

  @Override
  public String export(SummaryStatistics summaryStatistics) {
    try {
      return ObjectMapperHelper.objectMapper().writeValueAsString(summaryStatistics);
    } catch (JsonProcessingException e) {
      // 💡 과도하게 덤덤함으로 처리한 것 같은데...
      //     Notification 패턴을 써보라고 하셨지만..
      //     지금 써보긴 좀 그렇다. 😅
      throw new IllegalArgumentException(e);
    }
  }
}
