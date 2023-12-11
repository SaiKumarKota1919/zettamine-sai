package com.zettamine.day04.composition;

public class Student {
	protected int studentId;
	protected String name;
	protected int departmentId;
	protected String gender;
	protected String phone;
	protected Hosteller hosteller;
	
	public Hosteller getHosteller() {
		return hosteller;
	}
	public void setHosteller(Hosteller hosteller) {
		this.hosteller = hosteller;
	}
	public Student(int studentId, String name, int departmentId, String gender, String phone,Hosteller hosteller) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.departmentId = departmentId;
		this.gender = gender;
		this.phone = phone;
		this.hosteller = hosteller;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


}
