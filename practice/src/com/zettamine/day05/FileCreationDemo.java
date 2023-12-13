package com.zettamine.day05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreationDemo {
	public static void main(String[] args) {
		
		File file = new File("C:/CJava");
		
		//creating directory
		
		file.mkdir(); //creates directory CJava in C drive only if that directory not present
		
		File textFile = new File(file,"java.txt");
		
		try {
			textFile.createNewFile();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		try {
			FileWriter fileWriter = new FileWriter(textFile);
			fileWriter.write("Hello World");
			fileWriter.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
