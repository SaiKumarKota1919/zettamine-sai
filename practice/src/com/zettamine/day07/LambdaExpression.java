package com.zettamine.day07;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LambdaExpression {
	
	 
	public static void main(String[] args) {
		
		List<String> stringList = Arrays.asList("sai","sai kumar","ravi","ram","arun","sravan","kumar");
		
		//Collections.sort(stringList,(o1,o2)->o1.compareTo(o2));
		
		Set<String> set = new HashSet<String>();
		
		set.add("sai kumar");
		set.add("kumar");
		set.add("sai");
	
		
		Collections.sort(stringList,new Comparator<String>() {
		
			public int compare(String o1, String o2) {
				
				if(o1.compareTo(o2)>=0)
				{
					return -1;
				}
				else {
					return 1;
				}
				
			} ;
		});
		
		
		
		System.out.println(stringList);
	}

}
