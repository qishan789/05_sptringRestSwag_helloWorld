package com.qs.tst.swg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	@Value("${swaggerUI.psgURL:}")
	String psgURL;//"" empty
	
	@Value("${appConfig.mykey01}")
	String mykey01;
	
	public String getMykey01() {
		return mykey01;
	}
	
	ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API")
	            .description("Some description")
	            .version("1.0")
	            .contact(new Contact("the Team", "http://www.contact.com", "x.y@contact.com"))
	            .build();
	}
	
	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).host(psgURL)
				.select().apis(RequestHandlerSelectors.basePackage("com.qs.tst.swg.rest"))
				.build()
				.apiInfo(apiInfo()).enable(true);
	}

}
