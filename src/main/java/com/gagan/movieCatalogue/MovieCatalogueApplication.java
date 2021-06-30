package com.gagan.movieCatalogue;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class MovieCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogueApplication.class, args);
	}

	@Bean(initMethod = "migrate")
	Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource("jdbc:postgresql://localhost:5432/movies", "postgres", "gagan0894");
		flyway.setSchemas("movies_catalogue");
		return flyway;
	}
	@Bean
	public Docket swaggerConfiguration()
	{
		//Return a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/movieCatalogue/**"))
				.apis(RequestHandlerSelectors.basePackage("com.gagan"))
				.build()
				.apiInfo(apiDetails());
	}


	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Movie Catalogue API",
				"API to demonstrate basic operations on movie catalogue application",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Gagandeep Singh", "https://github.com/gagan0894/movieCatalogue", "gagandeep0894@gmail.com"),
				"API License",
				"https://www.mongodb.com",
				Collections.emptyList());
	}

}
