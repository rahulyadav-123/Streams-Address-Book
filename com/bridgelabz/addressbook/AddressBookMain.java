package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");
       AddressBook addressBook = new AddressBook();
        boolean choice = true;
        while (choice) {
            System.out.println("\nChoose the option:\nPress '1' for Add Contact Details\nPress '2' for Edit Contact Deatils"
                    + "\nPress '3' for Delete Contact Details\nPress '4' for Show Contact Details\nPress '5' for Contact list by City State"
                    + "\nPress '6' for Show Contact list of Persons\nPress '7' for Count of contacts by City State\nPress '8' for Sort Contacts By Name"
                    + "\nPress '0' for Exit");
            int option = scan.nextInt();
            switch (option) {
                case 0:
                    choice = false;
                    System.out.println("Exited out of AddressBook");
                    break;
                case 1:
                    addressBook.addDetails();
                    break;
                case 2:
                    addressBook.editDetails();
                    break;
                case 3:
                    addressBook.deleteDetails();
                    break;
                case 4:
                    addressBook.showDetails();
                    break;
                case 5:
                    addressBook.contactBycity();
                    break;
                case 6:
                    addressBook.displayContacts();
                    break;
                case 7:
                    addressBook.contactsCount();
                    break;
                case 8:
                    addressBook.sorting();
                    break;
                default:
                    System.out.println("Please enter valid input");
            }
        }
    }
}


