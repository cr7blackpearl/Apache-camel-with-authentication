package com.infy.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		System.out.println("In CloudConfig api gateway......");
		return builder.routes()
				.route(r -> r.path("/api/student/**")
						.uri("http://localhost:8091/")
						.id("studentManagementSystem"))
				
				.route(r -> r.path("/camel/student/**")
						.uri("http://localhost:9090/")
						.id("camelRestDsl"))
				
				.build();
		
	}

}
