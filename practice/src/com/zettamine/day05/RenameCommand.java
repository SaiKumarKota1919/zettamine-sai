package com.zettamine.day05;

import java.io.File;
import java.nio.file.Files;

public class RenameCommand {
	
	public static void main(String[] args) {
		
		// created a text file at project level
		
		// ren old-file new-file  (ren-rename)
		
		if(args.length==3 && args[0].equals("ren"))
		{
			File file = new File(args[1]);
			if(file.exists())
			{
				File fileName = new File(args[2]);
				file.renameTo(fileName);
				
				System.out.println("File with name "+args[1]+" is renamed to "+args[2]);
				
			}
			else {
				System.out.println("The system cannot find the file specified.");
			}
		}
		else {
			System.out.println("Please follow the command format as \" ren file_name new_file_name \" ");
		}
		
		
		
		
	}

}
