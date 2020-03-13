package com.infy.studmgmtsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.studmgmtsys.dao.StudentDao;
import com.infy.studmgmtsys.model.Student;
import com.infy.studmgmtsys.model.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student findStudentById(Long id) {
		Optional<Student> student = studentDao.findById(id);
		if(student.isPresent())
			return student.get();
		else
			return new Student();
	}

	@Override
	public Student save(Student student) {
		return studentDao.save(student);
	}
	
	@Override
	public StudentEntity getAllStudents() {
		List<Student> studentList = studentDao.findAll();
		StudentEntity studObj=new StudentEntity();
		studObj.setStudetnList(studentList);
		
		return studObj;
		
	}
	
}
