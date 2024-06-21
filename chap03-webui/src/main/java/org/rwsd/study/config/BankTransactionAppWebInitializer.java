package org.rwsd.study.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BankTransactionAppWebInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {
      BankTransactionAppRootConfig.class, //
      BankTransactionAppWebConfig.class
    };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }
}
