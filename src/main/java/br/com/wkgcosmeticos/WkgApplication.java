package br.com.wkgcosmeticos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.wkgcosmeticos.controller.TokenFilter;



@SpringBootApplication
public class WkgApplication {
	@Bean
	public FilterRegistrationBean filtroJwt(){
		FilterRegistrationBean frb= new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
	}

	public static void main(String[] args) {
	 SpringApplication.run(WkgApplication.class, args);
	}
}
