package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	List<ContactPerson> list = new ArrayList<ContactPerson>();
	ContactPerson person = new ContactPerson();
	Scanner sc = new Scanner(System.in);
	
	public void addContact() {
		System.out.println("Enter number of person you need to create :");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Enter the first name of person");
            String fName = sc.next();
            if (fName.equalsIgnoreCase(person.getFirstName())) {
                System.out.println("The entered person is already exist.");
            } else {
                System.out.println("Enter the contact details of person ");
                createContact();
                System.out.println("contact added Successfully");
            }
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
				System.out.println("Choose field you want to Edit:");
                System.out.println("Enter\n 1.First Name\n 2.Last Name\n 3.City\n 4.State\n 5.Zip Code\n 6.Phone\n 7.Email");
                switch (sc.nextInt()) {
                	case 1:
                		System.out.println("Correct your First Name");
                		person.setFirstName(sc.next());
                    break;
                    case 2:
                        System.out.println("Correct your Last Name");
                        person.setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Correct your Address");
                        person.setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Correct your City");
                        person.setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Correct your State");
                        person.setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Correct your Zip");
                        person.setZip(sc.nextInt());
                        break;
                    case 7:
                        System.out.println("Correct your Phone Number");
                        person.setPhonenumber(sc.nextLong());
                    case 8:
                        System.out.println("Correct your Email");
                        person.setEmail(sc.next());
                }
			}
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
		if (!deleted) {
	            System.out.println("Name does not exit");
		 }
	}


	 public void contactBycity() {
	        System.out.println("Enter Name of City to get Contact List : ");
	        String city = sc.next();
	            System.out.print("\nContact list of persons across '"+city+"' is");
	            list.stream().filter(contactList -> contactList.getCity().equals(city)||contactList.getState().equals(city)).forEach(contactList -> {
	                System.out.println(contactList.getFirstName()+" "+contactList.getLastName());
	            });
	    }
	 
	 public void contactBystate() {
	        System.out.println("Enter Name of State to get Contact List : ");
	        String state = sc.next();
	            System.out.print("\nContact list of persons across '"+state+"' is");
	            list.stream().filter(contactList -> contactList.getCity().equals(state)||contactList.getState().equals(state)).forEach(contactList -> {
	                System.out.println(contactList.getFirstName()+" "+contactList.getLastName());
	            });
	    }
	 
	 
	public void getPersonNameByState(String State) {
        List<ContactPerson> result  = list.stream().filter(p ->p.getState().equals(State)).collect(Collectors.toList());
        for(ContactPerson contact: result){
            System.out.println("First Name: "+contact.getFirstName());
        }
	}
        
    // Get Person Name by city
    public void getPersonNameByCity(String cityName) {
        List<ContactPerson> result  = list.stream().filter(p ->p.getCity().equals(cityName)).collect(Collectors.toList());
        for(ContactPerson contact: result){
            System.out.println("First Name: "+contact.getFirstName());
        }
    }
    
    public void countList() {
        System.out.println("Enter Name of City or State to get count of Contacts across city or state");
        String nameCityState = sc.next();
        var result = new Object() {int count=0;};
        list.stream().filter(contactList -> contactList.getCity().equals(nameCityState)||contactList.getState().equals(nameCityState)).forEach(contactList -> {
            result.count++;
        });
        System.out.println("Number of contact persons in "+nameCityState+" is : "+result.count);
    }
}