package com.zettamine.serialzedeserialize;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable,Comparable<Employee>{
	/**
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empId;
	private String empName;
	private int deptNo;
	
	
	
	
	public Employee(int empId, String empName, int deptNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptNo = deptNo;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptNo=" + deptNo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptNo, empId, empName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return deptNo == other.deptNo && empId == other.empId && Objects.equals(empName, other.empName);
	}
	@Override
	public int compareTo(Employee o) {
		
		return this.empId-o.empId;
	}

}
