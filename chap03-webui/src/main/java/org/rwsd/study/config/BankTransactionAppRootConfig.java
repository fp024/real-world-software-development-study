package org.rwsd.study.config;

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
public class BankTransactionAppRootConfig {}
