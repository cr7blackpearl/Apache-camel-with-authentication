package com.infy.studmgmtsys.service;

import org.springframework.stereotype.Service;

import com.infy.studmgmtsys.model.Student;

@Service
public interface StudentService {
	public Student findStudentById(Long id);

	public Student save(Student stud);
}
