package com.globant.FinalProject;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class that configures the Swagger documentation tool.
 * 
 * @author Eduardo Salgueiro
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Cart API").apiInfo(apiInfo()).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).paths(regex("/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("REST Shopping Cart API")
				.description("REST Shopping cart API implemented with Spring Boot and MySQL").contact("Edward Salgueiro <edwarx@gmail.com>")
				.version("9001").build();
	}
}
