package br.com.dashboarddb;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class DashboardDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardDbApplication.class, args);
	}

	@Bean
	ServletRegistrationBean<FacesServlet> jsfServletRegistration (ServletContext servletContext) {
		//spring boot only works if this is set
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");		
		servletContext.setInitParameter("primefaces.THEME", "bootstrap");
		//registration
		ServletRegistrationBean<FacesServlet> srb = new ServletRegistrationBean<FacesServlet>();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList("*.xhtml"));
		srb.setLoadOnStartup(1);
		return srb;
	  }
	
	@Bean
	  public ViewResolver viewResolver() {
	    InternalResourceViewResolver irv = new InternalResourceViewResolver();
	    irv.setPrefix("/");
	    irv.setSuffix(".xhtml");

	    return irv;

	  }
}
