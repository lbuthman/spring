package com.learningcode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * simple config for non-web components
 */
@Configuration
@ComponentScan(basePackages={"com.learningcode"},
                excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {


}
