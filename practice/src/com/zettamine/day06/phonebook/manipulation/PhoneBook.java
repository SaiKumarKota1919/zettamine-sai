package com.zettamine.day06.phonebook.manipulation;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	private static List<Contact> phoneBookContancts = new ArrayList<Contact>();
	
	public static void addContact(Contact contactObj) 
	{
		phoneBookContancts.add(contactObj);
	}
	
	public static List<Contact> viewAllContacts() 
	{
		return phoneBookContancts;
	}
	public static Contact viewContactByPhoneNo(long phoneNumber) 
	{
		
		for(Contact contact:phoneBookContancts)
		{
			
			if(contact.getPhoneNumber()==phoneNumber)
			{
				return contact;
			}
		}
		return null;
	}
	
	public static boolean removeContact(long phoneNumber) 
	{
		for(Contact contact:phoneBookContancts)
		{
			if(contact.getPhoneNumber()==phoneNumber)
			{
				phoneBookContancts.remove(contact);
			}
		}
		return false;
	}

}
