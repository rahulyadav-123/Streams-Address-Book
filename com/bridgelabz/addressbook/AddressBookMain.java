package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to AddressBook Mangament System");
		Map<String, AddressBook> map = new HashMap<>();
        System.out.println("Enter Number of address book you want to add");
        int count = scan.nextInt();
        int i = 0;
        while (i < count) {
            System.out.println("Enter book name");
            String bookName = scan.next();
            AddressBook addressBook = new AddressBook();
            addressBook.choice();
			map.put(bookName, addressBook);
            i++;
        }
        System.out.println(map);
    }
   
	
}

