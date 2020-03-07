package com.infy.studentclientmgmt.servcie;

import org.springframework.stereotype.Service;

import com.infy.studentclientmgmt.model.Student;

@Service
public interface StudentClientService {

	public Student getStudentById(Long id);

	public Student saveStudent(Student stud);
}
