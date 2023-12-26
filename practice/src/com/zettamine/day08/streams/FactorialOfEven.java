package com.zettamine.day08.streams;

import java.util.Arrays;
import java.util.List;

public class FactorialOfEven {
	public static void main(String[] args) {
		
//		long fact = 1;
//	    for (int i = 2; i <= n; i++) {
//	        fact = fact * i;
//	    }		
		List<Integer> numList = Arrays.asList(4,3,2,13,11,21,4,4,4,2,2,6);
		
	int sum  =	numList.stream()
				.distinct()
				.filter(n->n%2==0)
				.mapToInt(n->{
					int fact =1;
					for(int i=2;i<=n;i++)
					{
						fact =fact*i;
					}
					return fact;
				}).sum();
	boolean isEvenStream = numList.stream()
			.distinct()
			.filter(n->n%2==0).allMatch(n->n%2==4);
	System.out.println(isEvenStream);
	
	System.out.println("sum of factorial of distinct even numbers :"+sum);
	}

}
