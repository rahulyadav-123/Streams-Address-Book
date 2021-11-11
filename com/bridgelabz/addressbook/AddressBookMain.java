package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	
	public void choose() {
        MultipleAddressBook multiAddressBook = new MultipleAddressBook();
        while (true) {
            System.out.println("Enter \n 1. To add The new AddressBook\n 2. To do AddressBook functions\n " +
                    "3. To delete the AddressBook\n 4. To Print the AddressBook\n 5. To Print the contacts in AddressBook\n " + 
            		"6. To serach the Person by city Name\n 7. To serach the Person by state Name\n. 0. to exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    multiAddressBook.addAddressBook();
                    break;
                case 2:
                    multiAddressBook.addressBookFunctions();
                    break;
                case 3:
                    multiAddressBook.deleteBook();
                    break;
                case 4:
                    multiAddressBook.printBook();
                    break;
                case 5:
                    multiAddressBook.printContactsInBook();
                    break;
                case 6:
                    System.out.println("Enter Name of City: ");
                    String cityName = scanner.next();
                    multiAddressBook.searchPersonByCity();
                    break;
                case 7: 
                    System.out.println("Enter Name of State: ");
                    String stateName = scanner.next();
                    multiAddressBook.searchPersonByState(stateName);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the wrong input");
            }
        }
    }
    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.choose();
    }
}

