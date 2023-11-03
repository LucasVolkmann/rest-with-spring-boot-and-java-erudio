package br.com.erudio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenApi() {
		return new OpenAPI()
			.info(
				new Info()
				.title("Restful with Java and Spring")
				.version("v1")
				.description("A project to learn about APIs REST with Spring and others tecnologies")
				.termsOfService("https://github.com/LucasVolkmann")
				.license(
						new License()
							.name("Apache 2.0")
							.url("https://github.com/LucasVolkmann")
						)
				);
	}
	
}
