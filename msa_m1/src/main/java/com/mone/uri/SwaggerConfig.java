package com.mone.uri;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket produceApi() {
		/*return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.mone.*"))
						.paths(PathSelectors.regex("/appm1/*")).build();
	*/
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("msam1_api").description("micro Services")
				.termsOfServiceUrl("open source").license("licensed under none").version("v2.0").build();
	}

}
