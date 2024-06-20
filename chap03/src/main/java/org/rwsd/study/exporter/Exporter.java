package org.rwsd.study.exporter;

import org.rwsd.study.domain.SummaryStatistics;

/** 예제 3-14. Exporter 인터페이스의 좋은 예 */
public interface Exporter {
  String export(SummaryStatistics summaryStatistics);
}
