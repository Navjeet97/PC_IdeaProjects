package com.navjeet;

import java.util.Scanner;


// as of now we can update the contact in the list which is already there
// we don't want to allow the 2 contacts with the same name



public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // as we defined a parameter in MobilePhone class

    private static MobilePhone mobilePhone =
            new MobilePhone("1234545");

    public static void main(String[] args) {

        boolean quit = false;
        starPhone();
        printActions();


        while (!quit) {

            System.out.println("Enter action: (6 to show " +
                    "available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {

                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }


    }

    // we are creating a separate method here
    // because we need to ask the name and then actually call the code

    private static void queryContact(){

        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact not found.");
            return;
        }

        System.out.println("Name: "+existingContactRecord.getName()
        +" phone number is - "+existingContactRecord.getPhoneNumber());

    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact not found.");
            return;
        }

       if (mobilePhone.removeContact(existingContactRecord)){
           System.out.println("Successfully deleted record");
       }
       else {
           System.out.println("Error deleting contact");
       }
    }


    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();

        // mobilePhone.queryContact()

        Contact existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("contact not found.");

            // why writing just return?
            // basically if we didn't find an entry we can't update it
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();

        // we can also do the static import of the Contact class

        Contact newContact = Contact.createContact(newName, newNumber);


        // finally calling public method of MobilePhone
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        }
        // we should not have got an error
        // because we already did a test before hand to find the contact

        // but in real world scenarios - multi user type world
        // this contact record might have been deleted
        // since the time we retrieved- when we were checking it
        else {
            System.out.println("Error updating record");
        }

    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phone = scanner.nextLine();

        //Contact contact = new Contact(name,phone);

        // Or we only use the reference to the Contact class
        // don't have to create a new object
        // It is also known as a factory method as well

        // So we have saved memory too
        Contact contact = Contact.createContact(name, phone);

        // we are taking advantage of boolean returned
        if (mobilePhone.addNewContact(contact)) {
            System.out.println("new contact added: name = " + name + ",  phone" +
                    " = " + phone);
        } else {
            System.out.println("cannot add, " + name + " already on file");
        }

    }


    private static void starPhone() {

        // In real world programming, you will initialize the memory here
        // and all sort of other functionality
        System.out.println("Starting phone....");

    }

    private static void printActions() {

        System.out.println("\n Available actions:\n Press");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" + "" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print list of available actions. ");
        System.out.println("Choose your action: ");
    }
/*   private static void printContact() {

        // the question arises : Should we iterate the contacts
        // in the contact ArrayList here or to do it in MobilePhone


       // System.out.println("Contact List");

        // mobilePhone.someGetter
        // we wouldn't be doing here
        // lets implement a printContact function with the MobilePhone class
        // we don't want here to know that an underlying ArrayList is used

        mobilePhone.printContacts();


    }*/

}
