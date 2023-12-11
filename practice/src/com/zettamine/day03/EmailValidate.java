package com.zettamine.day03;

public class EmailValidate {
	public static boolean isValidEmail(String email) {
	    if(email.matches("^[a-zA-Z0-9!-]+@(?:gmail|yahoo|zettamine)\\.(?:com|net|in)$")) {
	        return true;
	    } 
	    else {
	        return false;
	    }
	}


}
