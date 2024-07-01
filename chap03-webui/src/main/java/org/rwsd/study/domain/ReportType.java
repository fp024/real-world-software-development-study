package org.rwsd.study.domain;

import lombok.Getter;
import org.rwsd.study.exporter.Exporter;
import org.rwsd.study.exporter.HtmlExporter;
import org.rwsd.study.exporter.JsonExporter;
import org.rwsd.study.exporter.XmlExporter;

@Getter
public enum ReportType {
  HTML(HtmlExporter.class),
  JSON(JsonExporter.class),
  XML(XmlExporter.class);

  private final Class<? extends Exporter> exporterClass;

  ReportType(Class<? extends Exporter> exporterClass) {
    this.exporterClass = exporterClass;
  }
}
