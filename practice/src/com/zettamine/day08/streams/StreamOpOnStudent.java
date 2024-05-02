package com.zettamine.day08.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamOpOnStudent {
	
	public static void main(String[] args) {
	List<Student> list = Arrays.asList(
			    new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
			    new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
			    new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
			    new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
			    new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
			    new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
			    new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
			    new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
			    new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
			    new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
	
	
	//Find list of students whose first name starts with alphabet A
		List<Student> stuListWithNameA = list.stream()
											.filter(stu->stu.getFirstName().startsWith("A"))
											.collect(Collectors.toList());
		System.out.println(stuListWithNameA);
		
		//Group The Student By Department Names
		Map<String,List<Student>> mapGroupByDept = list.stream()
												  .collect(Collectors.groupingBy(stu->stu.getDepartmantName()));
			System.out.println(mapGroupByDept);
			//Find the total count of student using stream
			Long count = list.stream().count();
			System.out.println(count);
			
			//Find the max age of student
			
		IntSummaryStatistics intSummaryStatistics =	list.stream()
																.mapToInt(s->s.getAge())
																.summaryStatistics();
		System.out.println(intSummaryStatistics.getMax());
		
	  //Find all departments names
		list.stream()
			.distinct()
			.map(s->s.getDepartmantName())
			.forEach(dept->System.out.println(dept));
		
		// Find the count of student in each department
		Map<String, Long> countByDeptMap = list.stream()
								.collect(Collectors.groupingBy(s->s.getDepartmantName(),Collectors.counting()));
		System.out.println(countByDeptMap);
		
		System.out.println("---------------------------------------------------");
		
		List<Entry<String, Long>> list2 = countByDeptMap.entrySet().stream().toList();
		list2.forEach(s->System.out.println(s));
		
		//Find the list of students whose age is less than 30
		//Find the list of students whose rank is in between 50 and 100
		// Find the average age of male and female students
		//Find the department who is having maximum number of students
		// Find the Students who stays in Delhi and sort them by their names
		//Find the average rank in all departments
		//Find the highest rank in each department
		// Find the list of students and sort them by their rank
		//Find the student who has second rank
	}

}
