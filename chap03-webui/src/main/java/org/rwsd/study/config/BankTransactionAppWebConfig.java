package org.rwsd.study.config;

import java.nio.charset.StandardCharsets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan(
    value = "org.rwsd.study",
    useDefaultFilters = false,
    includeFilters = {
      @Filter(classes = Controller.class),
    })
public class BankTransactionAppWebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("redirect:/index");
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.viewResolver(thymeleafViewResolver());
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/*.html", "/favicon.ico") //
        .addResourceLocations("classpath:/statics/");

    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("/webjars/")
        .resourceChain(false);
  }

  @Bean
  SpringResourceTemplateResolver thymeleafTemplateResolver() {

    final SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setPrefix("classpath:/templates/");
    resolver.setSuffix(".html");
    resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    resolver.setTemplateMode(TemplateMode.HTML);
    resolver.setCacheable(false); // 💡 개발중일 때는 캐시를 꺼주자
    return resolver;
  }

  @Bean
  SpringTemplateEngine thymeleafTemplateEngine() {

    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(thymeleafTemplateResolver());
    return templateEngine;
  }

  @Bean
  ThymeleafViewResolver thymeleafViewResolver() {
    final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(thymeleafTemplateEngine());
    // 아래 인코딩 설정이 필수였다. 이것을 설정하지 않으면 한글 처리 자체가 안됨.
    viewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    return viewResolver;
  }
}
