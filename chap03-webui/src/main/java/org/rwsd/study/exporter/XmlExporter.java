package org.rwsd.study.exporter;

import static org.rwsd.study.util.XmlMapperHelper.xmlMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.rwsd.study.domain.SummaryStatistics;

public class XmlExporter implements Exporter {
  @Override
  public String export(SummaryStatistics summaryStatistics) {
    try {
      return xmlMapper().writeValueAsString(summaryStatistics);
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
