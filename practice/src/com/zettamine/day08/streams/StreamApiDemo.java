package com.zettamine.day08.streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


public class StreamApiDemo {
	
	public static void main(String[] args) {
		
		List<String> courseList = Arrays.asList("core java","Advance java","spring","spring boot","microservices");
		
		//courseList.stream().map(str->str.toUpperCase()).forEach(str->System.out.printf("%-20s  -  %d\n",str,str.length()));
		 courseList.stream().map(str->String.format("%-15s  -  %d",str,str.length())).forEach(str->System.out.println(str));
	  
	  List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,9,0);
	  
	  IntSummaryStatistics stats = intList.stream().mapToInt(n->Integer.valueOf(n)).summaryStatistics();
	  
 	 System.out.println(stats.getAverage());
 	 
 	 System.out.println(intList.stream().collect(Collectors.averagingInt(n->n)));
	   
	}
	

}
