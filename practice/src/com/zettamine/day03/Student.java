package com.zettamine.day03;

import java.util.Objects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student implements Comparable<Student>{
	
 private String studentId;
 private String studentName;
 private String studentEmail;
 private static String collegeName;
 private static int id=101;
 static {
	 collegeName="VITS";
	 
 }
 
public Student( String studentName, String studentEmail) {
	super();
	
	this.studentId = "ZETTA_"+(id++);
	this.studentName = studentName;
	this.studentEmail = studentEmail;
}
@Override
public int hashCode() {
	return Objects.hash(studentEmail, studentId, studentName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	return Objects.equals(studentEmail, other.studentEmail) && Objects.equals(studentId, other.studentId)
			&& Objects.equals(studentName, other.studentName);
}
public static String getCollegeName() {
	return collegeName;
}
@Override
public int compareTo(Student o) {

	
	return this.studentId.compareTo(o.studentId);
}


 

}
