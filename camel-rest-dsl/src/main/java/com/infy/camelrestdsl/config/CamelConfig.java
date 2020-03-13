package com.infy.camelrestdsl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {
	@Value("${camel.rest.api-component}")
    public String CAMEL_COMPONENT;
	
	@Value("${camel.rest.port}")
	public String CAMEL_PORT;
	
	@Value("${camel.rest.api-host}")
	public String CAMEL_HOST;
	
	@Value("${students.url}")
	public String STUDENT_API;
	

}
