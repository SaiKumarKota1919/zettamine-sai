package com.zettamine.day05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.StandardCopyOption;

public class CopyFiles {

	public static void main(String[] args) {

		// the command format is "copy <source_path> <destination_path>"

		if (args.length == 3 && args[0].equals("copy")) {

			File sourceFile = new File(args[1]);
			File destinationFile = new File(args[2]);
			
			//if source file is not exists
			if (!sourceFile.exists()) {
				System.out.println("The system cannot find the file specified.");
				System.exit(0);
			}
			
			
			destinationFile.mkdir(); 

			//  if Source file is a directory call copyDirectory
			if (sourceFile.isDirectory()) {

				copyDirectory(sourceFile, destinationFile);
			} else {

				copyFiles(sourceFile, destinationFile);
			}

		} else {
			
			System.out.println("Please follow the command format as \" copy <source> <destinatio> \" ");
		}

	}

	private static void copyFiles(File sourceFile, File destinationFile) {
			
		try {
			
			Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File copied successfully!");
		} catch (IOException e) {
			System.out.println("Error copying file: " + e.getMessage());
		}

	}

	private static void copyDirectory(File sourceFile, File destinationFile) {

		destinationFile.mkdir();
		File[] filesList = sourceFile.listFiles();
		if (filesList != null) {
			for (File file : filesList) {
				File newFile = new File(destinationFile, file.getName()); // crating a file instance for destination
				// checking  inside file is there any director 
				if (file.isDirectory()) {
					
					copyDirectory(file, newFile); //Recursion
				} else {
					copyFiles(file, newFile);
				}
			}
		}

	}

}
