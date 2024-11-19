package com.coleta.monetiza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	OpenAPI getOpenAPIConfig() {
		OpenAPI openApi = new OpenAPI();
		Contact contact = new Contact()
						.name("ACP")
						.email("audrin@acquapix.com");
							
		License license = new License()
								.name("Apache 2.0")
								.url("http://springdoc.org");
		Info info = new Info()
			.title("Aplicação PegLev")
			.description("API Conta de Tokenização")
			.version("v1.0.0")
			.contact(contact)
			.license(license);
		return openApi.info(info);
	}	
}
