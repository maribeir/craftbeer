package com.beerhouse;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Aplicação SpringBoot.
 * 
 * @author Matheus R. Torres
 * @version 1.0.0
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.beerhouse")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

	@Bean
	public Swagger2DocumentationConfiguration swagger2Config(){
		return new springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration();
	}

	@Bean
	public SwaggerConfiguration swaggerConfig(){
		return new SwaggerConfiguration();
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
}