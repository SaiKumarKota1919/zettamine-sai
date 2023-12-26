package com.zettamine.day06.book.manipulation;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    
	public static void main(String[] args) {
		

		
		
		processRequest();
	}

	private static void processRequest() {
		Scanner scanner = new Scanner(System.in);
		

		while (true) {
			System.out.println("1. Add Book\r\n"
					+ "2. Display all Book Details\r\n"
					+ "3. Search Book by Author \r\n"
					+ "4. Count Number of books - by book name\r\n"
					+ "5. Exit\r\n");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			
			case 1:
				System.out.print("Enter the isbn no: ");
				long isbNo = scanner.nextLong();
				scanner.nextLine();
				System.out.print("Enter the book name: ");
				String bName = scanner.nextLine();
				System.out.print("Enter the author name: ");
				String authName = scanner.nextLine();
				Library.addBook(new Book(isbNo, bName, authName));

				break;
			case 2:
					if(Library.isEmpty())
					{
						System.out.println("No books available in the library");
					}
					else {
						System.out.println("=".repeat(60));
						System.out.println("BOOK_ISB_NO   |   BOOK_TITLE         |    AUTHER_NAME      |");
						System.out.println("=".repeat(60));
						
						 for(Book book : Library.viewAllBooks())
						  {
							  System.out.printf("%-13s | %-20s | %-20s|\n",book.getIsbnNo(),book.getBookTitle(),book.getBookAuthor());
							  System.out.println("-".repeat(60));
						  }
						
					}
				 

				break;
			case 3:System.out.print("enter auther name : ");
			String autherName = scanner.nextLine();
					List<Book> list = Library.viewBooksByAuthors(autherName);
					if(list==null)
					{
						System.out.println("no books found for the auther name "+autherName);
					}
					else {
						System.out.println("=".repeat(60));
						System.out.println("BOOK_ISB_NO   |   BOOK_TITLE         |    AUTHER_NAME      |");
						System.out.println("=".repeat(60));
						
						 for(Book book : list)
						  {
							  System.out.printf("%-13s | %-20s | %-20s|\n",book.getIsbnNo(),book.getBookTitle(),book.getBookAuthor());
							  System.out.println("-".repeat(60));
						  }
						
					}
			

				break;
			case 4:System.out.print("enter book title : ");
				String bookTitle = scanner.nextLine();
				System.out.println("No of "+bookTitle+" books are "+Library.countNoOfBooks(bookTitle));

				break;
			case 5:scanner.close();
			System.out.println("Exit of the Application_________");
				System.exit(0);
				
				break;

			default:System.out.println("Invalid choice try again!!!!");
				break;
			}
			
		}
		
		

	}
}
