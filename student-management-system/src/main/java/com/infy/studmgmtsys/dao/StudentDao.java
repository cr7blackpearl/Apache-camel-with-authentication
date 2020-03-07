package com.infy.studmgmtsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.studmgmtsys.model.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
	

}