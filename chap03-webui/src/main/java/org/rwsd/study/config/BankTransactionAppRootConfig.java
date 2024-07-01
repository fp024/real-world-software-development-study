package org.rwsd.study.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import org.rwsd.study.BankTransactionAnalyzer;
import org.rwsd.study.domain.ReportType;
import org.rwsd.study.exporter.Exporter;
import org.rwsd.study.exporter.HtmlExporter;
import org.rwsd.study.exporter.JsonExporter;
import org.rwsd.study.exporter.XmlExporter;
import org.rwsd.study.parser.BankStatementCSVParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@ComponentScan(
    value = "org.rwsd.study",
    excludeFilters = {
      @Filter(classes = Controller.class),
      @Filter(classes = Configuration.class),
    })
@Configuration
public class BankTransactionAppRootConfig {

  @Bean
  BankStatementCSVParser bankStatementCSVParser() {
    return new BankStatementCSVParser();
  }

  @Bean
  BankTransactionAnalyzer bankTransactionAnalyzer() {
    return new BankTransactionAnalyzer();
  }

  @Bean
  Map<ReportType, Exporter> exporterMap() {
    Map<ReportType, Exporter> exporterMap = new EnumMap<>(ReportType.class);
    exporterMap.put(ReportType.HTML, new HtmlExporter());
    exporterMap.put(ReportType.JSON, new JsonExporter());
    exporterMap.put(ReportType.XML, new XmlExporter());
    return Collections.unmodifiableMap(exporterMap);
  }
}
