package com.angular;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class SitoFullStackAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitoFullStackAngularApplication.class, args);
	}

	 @Bean
	  public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	 
	    corsConfiguration.setAllowCredentials(true);
	    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	    corsConfiguration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
	    corsConfiguration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
	    source.registerCorsConfiguration("/**", corsConfiguration);
	    return new CorsFilter(source);
	  }
}
