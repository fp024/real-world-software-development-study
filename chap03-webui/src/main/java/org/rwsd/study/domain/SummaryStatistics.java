package org.rwsd.study.domain;

import lombok.Getter;

/** 예제 3-12. 요약 정보를 저장하는 도메인 객체 */
@Getter
public class SummaryStatistics {
  private final double sum;
  private final double max;
  private final double min;
  private final double average;

  public SummaryStatistics(
      final double sum, final double max, final double min, final double average) {
    this.sum = sum;
    this.max = max;
    this.min = min;
    this.average = average;
  }
}
