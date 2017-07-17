package com.beerhouse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe de configuração do Swagger.
 * 
 * @author Matheus R. Torres
 * @version 1.0.0
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(new String[]{"css/", "images/", "lib/", "swagger-ui.js"})
				.addResourceLocations("classpath:META-INF/resources/").setCachePeriod(0);
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("classpath:/resources/");
		resolver.setSuffix(".html");
		return resolver;
	}

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.description("No description")
				.version("1.0.0")
				.title("CraftBeer")
				.build();
	}
}