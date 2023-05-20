package com.ssafy.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//swagger 사용을 위해 선언한다.
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	/**
	 * Swagger를 위한 Docket 빈을 추가한다.
	 * 
	 * @return
	 */
	
	private String version = "V1";
	private String title = "WhereIsMyHome API " + version;
	
	private ApiInfo apiInfo() {
		String descript = "SSAFY Vuejs API Reference for Developers<br>";
		return new ApiInfoBuilder().title(title).description(descript)
//				.termsOfServiceUrl("https://edu.ssafy.com")
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com")).license("SSAFY License")
				.licenseUrl("ssafy@ssafy.com").version("1.0").build();
	}
	
	// API마다 구분짓기 위한 설정.
	@Bean
	public Docket userApi() {
		return getDocket("회원", Predicates.or(PathSelectors.regex("/user.*")));
	}

	@Bean
	public Docket searchApi() {
		return getDocket("게시판", Predicates.or(PathSelectors.regex("/board.*")));
	}

	@Bean
	public Docket commonApi() {
		return getDocket("아파트", Predicates.or(PathSelectors.regex("/house.*")));

	}
	@Bean
	public Docket dongApi() {
		return getDocket("동", Predicates.or(PathSelectors.regex("/dong.*")));

	}

	@Bean
	public Docket allApi() {
		return getDocket("전체", Predicates.or(PathSelectors.regex("/*.*")));
	}

	public Docket getDocket(String groupName, Predicate<String> predicate) {
		return new Docket(DocumentationType.SWAGGER_2).groupName(groupName).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.home.controller")).paths(predicate)
				.apis(RequestHandlerSelectors.any()).build();

	}

	// swagger ui 설정.
	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().displayRequestDuration(true).validatorUrl("").build();
	}
	
	
	
}
