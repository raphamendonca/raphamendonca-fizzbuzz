package com.github.raphamendonca.raphamendoncafizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RaphamendoncaFizzbuzzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaphamendoncaFizzbuzzApplication.class, args);
	}
	
	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.github.raphamendonca.raphamendoncafizzbuzz"))
				.paths(PathSelectors.ant("/fizzBuzz/*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Raphael Mendonça FizzBuzz API").version("1.0.0").build();
	}
}
