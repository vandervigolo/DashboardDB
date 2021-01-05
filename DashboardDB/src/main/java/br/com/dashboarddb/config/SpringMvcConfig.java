package br.com.dashboarddb.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan("br.com.dashboarddb")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	
}
