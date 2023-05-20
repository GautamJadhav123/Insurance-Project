package com.insuranceApp;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import org.modelmapper.ModelMapper;



@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class SpringBootInsuranceApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInsuranceApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
				   .paths((Predicate<String>) PathSelectors.any())
				   .build()
				   .apiInfo(apiInformation());
	}
	
	
	private ApiInfo apiInformation() {
		
		return new ApiInfo(
				   "Insuracne Project Apis",
			       "Apis for policy management module",
			       "Version 1.0",
			       null,
			       new Contact("Gautam Jadhav", null,"gautamjadhav12597@gmail.com"),
			       null,
			       null,
			       Collections.emptyList());	
	}
}
