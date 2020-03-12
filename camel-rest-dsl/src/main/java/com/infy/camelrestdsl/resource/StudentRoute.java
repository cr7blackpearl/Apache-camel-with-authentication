package com.infy.camelrestdsl.resource;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.infy.camelrestdsl.config.CamelConfig;
import com.infy.camelrestdsl.dto.Student;

@Component
public class StudentRoute extends RouteBuilder {

	@Autowired
	private CamelConfig camelConfig;

	JacksonDataFormat format = new JacksonDataFormat(Student.class);

	@Override
	public void configure() throws Exception {

		restConfiguration().component(camelConfig.CAMEL_COMPONENT).port(camelConfig.CAMEL_PORT)
				.host(camelConfig.CAMEL_HOST).bindingMode(RestBindingMode.json);

		getStudentById();

		addStudent();

	}

	private void getStudentById() {
		rest().get("/student/{id}").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.toD(camelConfig.STUDENT_API + "${header.id}?bridgeEndpoint=true").unmarshal(format)
				.log("Camel GET for retriving student......");
	}

	private void addStudent() {
		rest().post("/student").consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
				.route().marshal(format).toD(camelConfig.STUDENT_API + "${header.student}?bridgeEndpoint=true")
				.unmarshal(format).log("Camel Post for Adding Student.....");

	}
}
