package com.zettamine.day06.book.manipulation;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private static List<Book> bookList = new ArrayList<Book>();

	

	
	
	
	public static void addBook(Book book) {
		
		bookList.add(book);
		
	}
	public static boolean isEmpty() {
		
		if(bookList.isEmpty())
		{
			return true;
		}
		return false;
		
	}
	
	 
	public static List<Book> viewAllBooks() {
		
	return bookList;
	
	}
	
	public static int countNoOfBooks(String bName) {
		
		int count =0;
		
		for(Book book: bookList)
		{
			if(book.getBookTitle().equals(bName))
			{
				count++;
			}
		}
		return count;
		
	}
	
	public static List<Book> viewBooksByAuthors(String author) {
		
		List<Book> list = new ArrayList<Book>();
		
		for(Book book : bookList)
		{
			if(book.getBookAuthor().equals(author))
			{
				list.add(book);
			}
		}
		if(list.size()>0)
		{
			return list;
		}
		return null;
		
	}

}
