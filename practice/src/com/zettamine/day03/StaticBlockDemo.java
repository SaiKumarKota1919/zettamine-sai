package com.zettamine.day03;

public class StaticBlockDemo {
	private  int blockId;
	private  String blockName;
	static
	{
		blockType = "####";
		System.out.println("Static block-1");
	}
	static 
	
	{
		blockgroup = 20;
		System.out.println("static block-3");
	}
	public static void main(String[] args) {
		System.out.println("in main method");
		
	}
	private static int blockgroup;
	private static String blockType;
	static
	{
		System.out.println("static block-2");
	}
	
	static
	{
		System.out.println("static block-4");
	}
	

}
