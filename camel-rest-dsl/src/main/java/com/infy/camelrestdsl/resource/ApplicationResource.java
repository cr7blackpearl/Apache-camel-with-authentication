package com.infy.camelrestdsl.resource;

import com.infy.camelrestdsl.dto.Student;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.infy.camelrestdsl.dto.Order;
import com.infy.camelrestdsl.processor.OrderProcessor;
import com.infy.camelrestdsl.service.OrderService;

@Component
public class ApplicationResource extends RouteBuilder {

	@Autowired
	private OrderService orderServcie;

	@BeanInject
	private OrderProcessor orderProcessor;

	@Override
	public void configure() throws Exception {

		JacksonDataFormat format = new JacksonDataFormat(Student.class);
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);

		rest().get("/hello").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("Hi"));

		rest().get("/getOrders").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(order -> orderServcie.getOrders()).endRest();

		rest().post("/addOrder").consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class)
				.route().process(orderProcessor).endRest();

		rest().get("/getStudent/{id}").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.toD("http://localhost:8091/api/student/${header.id}?bridgeEndpoint=true").unmarshal(format);

		rest().post("/addStudent").consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
					.route().marshal(format).toD("http://localhost:8091/api/student/${header.student}?bridgeEndpoint=true")
							.unmarshal(format).log("Camel Post for Adding Student.....");

	}

}
