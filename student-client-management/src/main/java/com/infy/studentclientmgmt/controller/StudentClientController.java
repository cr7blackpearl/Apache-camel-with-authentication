package com.infy.studentclientmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.studentclientmgmt.model.Student;
import com.infy.studentclientmgmt.servcie.StudentClientService;

@RestController
@RequestMapping("/client")
public class StudentClientController {

	@Autowired
	private StudentClientService studentClientService;

	@GetMapping("/{id}")
	public Student getStudentDetails(@PathVariable Long id) {
		return studentClientService.getStudentById(id);
	}

	@PostMapping()
	public Student saveStudent(@RequestBody Student stud) {
		Student savedStudent = studentClientService.saveStudent(stud);

		return savedStudent;
	}

}
