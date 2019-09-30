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
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Raphael Mendonça FizzBuzz API")
				.description("Fizz Buzz Game API\n"
						+ "To play use this api to check a fizzBuzz number. Here the rules:\n" + 
						"- If the informed number is could be divide by 3 will be returned \"Fizz\";\n" + 
						"- If the informed number is could be divide by 5 will be returned \"Buzz\";\n" + 
						"- If the informed number is could be divide by 15 will be returned \"FizzBuzz\";\n" + 
						"- If is not divide by 3, 5 or 15 the given umber will be returned;\n" + 
						"")
				.version("1.0.0")
				.build();
	}
}
