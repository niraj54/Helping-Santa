package com.Helping.Santa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan(basePackages = "com.Helping.Santa.demo")
@SpringBootApplication
public class HelpingSantaApplication  extends SpringBootServletInitializer implements WebMvcConfigurer{
	
	

	public static void main(String[] args) {
		SpringApplication.run(HelpingSantaApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HelpingSantaApplication.class);
	}
	
	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedMethods("GET", "POST", "PUT", "PATCH",
	 * "DELETE", "OPTIONS"); WebMvcConfigurer.super.addCorsMappings(registry); }
	 */

}
