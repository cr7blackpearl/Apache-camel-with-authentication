package com.infy.camelrestdsl.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.infy.camelrestdsl.config.CamelConfig;
import com.infy.camelrestdsl.models.Student;
import com.infy.camelrestdsl.models.StudentEntity;

@Component
public class StudentRoute extends RouteBuilder {

	@Autowired
	private CamelConfig camelConfig;

	@Override
	public void configure() throws Exception {
		camelRestConfig();
		getAllStudent();
		getStudentById();
		addStudent();

	}

	private void getAllStudent() {
		JacksonDataFormat format = new JacksonDataFormat(StudentEntity.class);
		rest().get("/student").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.toD(camelConfig.STUDENT_API + "?bridgeEndpoint=true").unmarshal(format)
				.log("Camel GET for retriving All Student......");
		
	}

	private void camelRestConfig() {
		restConfiguration().component(camelConfig.CAMEL_COMPONENT).port(camelConfig.CAMEL_PORT)
				.host(camelConfig.CAMEL_HOST).bindingMode(RestBindingMode.json);

	}

	private void getStudentById() {
		JacksonDataFormat format = new JacksonDataFormat(Student.class);
		rest().get("/student/{id}").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.toD(camelConfig.STUDENT_API + "${header.id}?bridgeEndpoint=true").unmarshal(format)
				.log("Camel GET for retriving Student......");
	}

	private void addStudent() {
		JacksonDataFormat studDataFormat = new JacksonDataFormat(Student.class);
		rest().post("/student").consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
				.route().marshal(studDataFormat).toD(camelConfig.STUDENT_API + "${header.student}?bridgeEndpoint=true")
				.unmarshal(studDataFormat).log("Camel Post for Adding Student.....");

	}
}
