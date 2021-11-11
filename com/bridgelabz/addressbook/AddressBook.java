package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	
	List<ContactPerson> list = new ArrayList<ContactPerson>();
	ContactPerson person = new ContactPerson();
	Scanner sc = new Scanner(System.in);
	
	public void addContact() {
		System.out.println("Enter number of contacts you need to create :");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			createContact();
		}
	}
	
	public void createContact() {
		System.out.println("Enter First Name : ");
		String firstName = sc.next();
		System.out.println("Enter Last Name : ");
		String lastName = sc.next();
		System.out.println("Enter Address : ");
		String address = sc.next();
		System.out.println("Enter City : ");
		String city = sc.next();
		System.out.println("Enter State : ");
		String state = sc.next();
		System.out.println("Enter Zip : ");
		int zip = sc.nextInt();
		System.out.println("Enter Mobile Number : ");
		long phoneNumber = sc.nextLong();
		System.out.println("Enter Email : ");
		String email = sc.next();
		person = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
		list.add(person);
		printContact();		
	}
	
	public void printContact() {
		for(int i = 0; i < list.size(); i++) {
			System.out.println("Contact Details Are: ");
			System.out.println("Name 	     : "  + person.getFirstName() + " " + person.getLastName() + "\n"
					+ "Address      : "  + person.getAddress() + "\n"
					+ "City         : "  + person.getCity() + "\n"
					+ "State        : "  + person.getState() + "\n"
					+ "ZipCode      : "  + person.getZip() + "\n"
					+ "MobileNumber : "  + person.getPhonenumber() + "\n"
					+ "EmailId      : "  + person.getEmail() + "\n" );
		}
	}
	
	public void editContact() {
		System.out.println("Enter the First name to edit the contact: ");
		String editName = sc.next();
		boolean edited = false;
		for(int i = 0; i < list.size(); i++) {
			String name = list.get(i).getFirstName();
			if(name.equalsIgnoreCase(editName)) {
				createContact();
				edited = true;
				break;
			}
		}
		if(!edited) {
			System.out.println("Name does not exist");
		}
	}
	
	public void deleteContact() {
		System.out.println("Enter the First name of the person to delete the contact :");
		String deleteName = sc.next();
		boolean deleted = false;
		for(int i = 0; i< list.size(); i++) {
			String name = list.get(i).getFirstName();
			if(name.equalsIgnoreCase(deleteName)) {
				list.remove(i);
				deleted = true;
				break;
			}
		}
		printContact();		 
		if (!deleted) {
	            System.out.println("Name does not exit");
		 }
	}
}

	
		
	