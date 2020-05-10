package com.navjeet;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the ArrayList to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // static Scanner object to be created to be used by all the operations that we will define in our application
    private static Scanner scanner = new Scanner(System.in);

    // creating a static ArrayList of MobilePhone which will be remain unique until application quits
    // mobile phone is a list of contacts
    private static MobilePhone mobilePhone = new MobilePhone();


    public static void main(String[] args) {


        boolean quit = false;
        int choice = 0;
        printInstrunctions();

        while (!quit) {

            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 0:
                    printInstrunctions();
                    break;
                case 1:
                    // I will be creating a method to print all the elements of mobilePhone list
                    mobilePhone.printList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
// end of swirch
            }

// end of while loop
        }

// end of main() method
    }


    // method to print the Instructions
    public static void printInstrunctions() {

        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of items / contacts ");
        System.out.println("\t 2 - To add an item / contact to the contactList.");
        System.out.println("\t 3 - To modify an item / contact in the contactList");
        System.out.println("\t 4 - To remove an item / contact from the contactList");
        System.out.println("\t 5 - To search an item / contact in the contactList.");
        System.out.println("\t 6 - To quit the application");

    }

    // method to add items
    public static void printItems() {

        // facing trouble accessing the contactList private element
        // or way to determine the size of ArrayList i.e. contactList
    /*  for (int i = 0 ; i < mobilePhone.sizeOfContactList() ; i++){

          // how to print each element of ArrayList
          // I will use get(index) method of ArrayList
          // this is not an ideal way as per the Challenege given... i guess...

          System.out.println("Contact "+i+" of mobile phone is : "+contact);

      }*/

    // get contactList from mobilePhone and print all elements by iterating
        mobilePhone.printContacts();

        for (int i = 0 ; i< mobilePhone.sizeOfContactList(); i++){

            System.out.println("Contact "+(i+1)+" in mobile phone is :"+mobilePhone.printContacts().get(i));
        }

    }

    // method to add an item
    private  static void addItem(){

        Contacts contact = new Contacts();
        System.out.println("Enter Contact name : ");
        contact.setName(scanner.nextLine()) ;
        System.out.println("Eneter phone number : ");
        contact.setPhoneNumber(scanner.nextLine());


        mobilePhone.addContact(contact);

        System.out.println(contact+" added!");
    }


    // method to modify Item
    public static void modifyItem(){
        Contacts contact = new Contacts();
        System.out.println("Enter Contact name to modify  : ");
        contact.setName(scanner.nextLine()) ;
        System.out.println("Eneter phone number to modify : ");
        contact.setPhoneNumber(scanner.nextLine());

        Contacts contact2 = new Contacts();
        System.out.println("Enter new Contact name   : ");
        contact2.setName(scanner.nextLine()) ;
        System.out.println("Eneter new phone number : ");
        contact2.setPhoneNumber(scanner.nextLine());

        mobilePhone.modifyContact(contact2);

        System.out.println(contact+" modified!");

    }

    // method to remove item
    public static void removeItem(){
        Contacts contact = new Contacts();
        System.out.println("Enter Contact name to delete  : ");
        contact.setName(scanner.nextLine()) ;
        System.out.println("Eneter phone number to delete : ");
        contact.setPhoneNumber(scanner.nextLine());

        mobilePhone.removeContact(contact);

        System.out.println(contact+" removed");

    }

    // method to search a contact in MobilePhone
    public static void searchItem(){
        Contacts contact = new Contacts();
        System.out.println("Enter Contact name to search  : ");
        contact.setName(scanner.nextLine()) ;
        System.out.println("Eneter phone number to search : ");
        contact.setPhoneNumber(scanner.nextLine());

        mobilePhone.findContact(contact);

    }




    // end of class

}


// ArrayList to be created will accept a custom class having name and phone number named Contacts


// MobilePhone class will have a ArrayList of Contacts
// MobilePhone class will also add a contact, update/modify, delete & query contact i.e it will have all the functionality mentioned above
// Store contact (name & no.) , update/modify contact , remove contact , Query contact ( via name or no.)


// Menu of Options to be exposed - probably main method() will be its best place
// List of Option : - Quit, print list of contacts, add new contact, update existing contact , remove contact , search/find contact
// logic to check if the contact exists before adding and updating
// MobilePhone class should be encapsulated. Mobile will do everything through the contact object.
// other class object should no do direct .int or any .get(i) i.e the inner working of the ArrayList