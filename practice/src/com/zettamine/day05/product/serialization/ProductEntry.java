package com.zettamine.day05.product.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ProductEntry {
	static File file = new File("product.ser");

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter no of products :");
		int noOfProducts = scanner.nextInt();
		// reading products details based on number of products 
		System.out.println("Enter products details separated by spaces : ");
		for (int i = 0; i < noOfProducts; i++) {
			System.out.println("enter product id , product Name & product price for product :" + (i + 1));
			int pId = scanner.nextInt();
			String pName = scanner.next();
			int pPrice = scanner.nextInt();
			// serializing each product into a file by calling method
			serialzeProduct(new Product(pId, pName, pPrice));

		}
		
		//reading product id from user to find product
		System.out.print("enter product id to serach : ");
		int keyId = scanner.nextInt();
		// getting product based on key by calling a method
		Product product = getProductById(keyId);
		if (product == null) {
			
			System.out.println("product with id " + keyId + " is not available");
		} else {
			System.out.println("product details are : " + product.getProductId() + " " + product.getProductName() + " "
					+ product.getProductPrice());
		}
	}

	private static Product getProductById(int keyId) {

		try(InputStream inputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);){
			
			
			while (true) {
				try {
					// reading each object from file and type casting into Product
					Product product = (Product) objectInputStream.readObject();
					//comparing id
					if (product.getProductId() == keyId) {
						// if product found return product
						return product;
					}
				} catch (Exception e) {
					//if eof is reached exception is raised and break the loop
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//if product not find return null
		return null;

	}

	private static void serialzeProduct(Product product) {

	
		try(FileOutputStream fileOutputStream = new FileOutputStream(file);
	  ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			
			// if file is not present it creates a file 
			
			objectOutputStream.writeObject(product);

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
