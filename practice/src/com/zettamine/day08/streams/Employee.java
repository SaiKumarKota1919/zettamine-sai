package com.zettamine.day08.streams;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Employee {

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
    
    
    
    

    

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    public int getId() 
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public int getAge() 
    {
        return age;
    }
    public String getGender() 
    {
        return gender;
    }
    public String getDepartment() 
    {
        return department;
    }
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
    public double getSalary() 
    {
        return salary;
    }
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
    @Override
	public int hashCode() {
		return Objects.hash(age, department, gender, id, name, salary, yearOfJoining);
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
		return age == other.age && Objects.equals(department, other.department) && Objects.equals(gender, other.gender)
				&& id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& yearOfJoining == other.yearOfJoining;
	}

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        
        
        
        
        //Find out the count of male and female employees present in the organization?
    Map<String, Long> map =   employeeList.stream()
    										.collect(Collectors.groupingBy(emp->emp.getGender(),Collectors.counting()));
    System.out.println(map);
    
    //Write a program to print the names of all departments in the organization.
    
    employeeList.stream()
    			.map(Employee::getDepartment)
    			.distinct()
    			.forEach(dept->System.out.println(dept));
    
    //Find the average age of Male and Female Employees.
    Map<String, Double> averageAgeMap = employeeList.stream()
    							.collect(Collectors.groupingBy(emp->emp.getGender(),Collectors.averagingInt(emp->emp.getAge())));
    System.out.println();
    System.out.println(averageAgeMap);
    
    //Get the Names of employees who joined after 2015.
    System.out.println();
    employeeList.stream()
    			.filter(emp->emp.getYearOfJoining()>2015)
    			.map(emp->emp.getName())
    			.forEach(name->System.out.println(name));
    
    // Count the number of employees in each department.
    Map<String, Long> noOfEmpInDeptMap = employeeList.stream()
    												.collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.counting()));
    System.out.println();
    System.out.println(noOfEmpInDeptMap);
    
    // Find out the average salary of each department.
    Map<String, Double> averageSalMap = employeeList.stream()
    												.collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.averagingDouble(emp->emp.getSalary())));
   System.out.println();
    System.out.println(averageSalMap);
    
    //Find out the oldest employee, his/her age and department?
     Optional<Employee> maxAge = employeeList.stream().max((o1,o2)->o1.getAge()-o2.getAge());
     if(maxAge.isPresent())
     {
    	 System.out.println(maxAge.get().getName());
     }
     
     //Find out the average and total salary of the organization.
     
   DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
		   														.mapToDouble(emp->Double.valueOf(emp.getSalary()))
		   														.summaryStatistics();
   
    System.out.println("total salary : "+doubleSummaryStatistics.getSum());
    System.out.println("average salary : "+doubleSummaryStatistics.getAverage());
    System.out.println();
    
    //List down the employees of each department
    Map<String, List<Employee>> deptEmpMap = employeeList.stream().collect(Collectors.groupingBy(emp->emp.getDepartment()));
    
    for(Map.Entry<String, List<Employee>> entry : deptEmpMap.entrySet())
    {
    	System.out.println("employees in "+entry.getKey());
    	System.out.println("-".repeat(40));
    	for(Employee emp:entry.getValue())
    	{
    		System.out.println(emp.getName());
    	}
    }
    
    System.out.println();
  // Find out the highest experienced employees in the organization
   Optional<Employee> empOptional = employeeList.stream()
		   .sorted((e1,e2)->e1.getYearOfJoining()-e2.getYearOfJoining())
		   .findFirst();
   if(empOptional.isPresent())
   {
	   System.out.println(empOptional.get().getName());
   }
   
    }
 }
