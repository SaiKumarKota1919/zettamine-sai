  package com.zettamine.day01;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeastDiscoutOffer {
	static Map<String, Double> itemsMap = new HashMap<String, Double>();
	public static void main(String[] args) {
		String[] itemArray ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of items :");
		int noOfItems = scanner.nextInt();
		scanner.nextLine();
		System.out.println("The input is the item name, price and discount percentage separated by comma(,)");
		System.out.println("Enter "+ noOfItems+" items details:");
		for(int i=0;i<noOfItems;i++)
			
		{
			String string = scanner.nextLine();
			itemArray = string.split(",");
			
			insertItemsIntoMap(itemArray);
			
		}
		System.out.println("Items with Minimum Discount: "+getLeastDiscountProducts());
		scanner.close();
	}

	

	private static void insertItemsIntoMap(String[] itemArray) 
	
	{
		
		int itemPrice = Integer.parseInt(itemArray[1]);
		int discountPercent = Integer.parseInt(itemArray[2]);
		double discountAmount = itemPrice* ((double)discountPercent)/100;
		itemsMap.put(itemArray[0], discountAmount);
		
		
	}
	private static StringBuffer getLeastDiscountProducts() {
		StringBuffer stringBuffer = new StringBuffer("");
		double minDiscount = Collections.min(itemsMap.values());
		
		for(Map.Entry<String, Double> entry : itemsMap.entrySet())
		{
			if(entry.getValue()==minDiscount)
			{
				stringBuffer = stringBuffer.append(" ").append(entry.getKey());
			}
		}
		
		
		return stringBuffer;
	}

}
