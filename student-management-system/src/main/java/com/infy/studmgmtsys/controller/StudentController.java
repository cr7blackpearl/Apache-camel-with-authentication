package com.infy.studmgmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.studmgmtsys.model.Student;
import com.infy.studmgmtsys.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping()
	public Student saveStudent(@RequestBody Student stud) {
		Student savedStudent = studentService.save(stud);
		return savedStudent;
	}

	@GetMapping("/{id}")
	public Student getStudentDetails(@PathVariable Long id) {
		return studentService.findStudentById(id);
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
}
