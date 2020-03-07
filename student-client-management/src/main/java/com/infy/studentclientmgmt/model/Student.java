package com.infy.studentclientmgmt.model;

public class Student {

	private Long id;

	private String name;

	private String gender;

	private String address;

	private String contactNo;

	public Student() {

	}

	public Student(Long id, String name, String gender, String address, String contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.contactNo = contactNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
