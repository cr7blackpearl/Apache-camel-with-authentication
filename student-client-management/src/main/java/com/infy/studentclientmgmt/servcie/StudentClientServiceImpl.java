package com.infy.studentclientmgmt.servcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.studentclientmgmt.model.Student;

@Service
public class StudentClientServiceImpl implements StudentClientService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Student getStudentById(Long id) {

		return restTemplate.getForObject("http://localhost:9090/student/"+id, Student.class);
	}

	@Override
	public Student saveStudent(Student stud) {

		return restTemplate.postForObject("http://localhost:9090/student", stud, Student.class);
	}

	
}
