package com.navjeet;

import java.util.ArrayList;

public class MobilePhone {

    // optional - creating a option to store the phoneNumber
    private String myNumber;

    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;

        // lets initialize our ArrayList
        this.myContacts = new ArrayList<Contact>();
    }


    // method 1 : add new contact in the Contact ArrayList
    public boolean addNewContact(Contact contact) {

        if (findContact(contact.getName()) >= 0) {
            System.out.println("contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;

    }

    // find Contact - overloaded with index and other with contact name
    // both these overloaded methods return integers,
    // which we don't want to pass back to the calling program
    // so we will make another public method after these methods
    // which will be accessed publicly to find a contact in the List


    // I don't want the calling program to access the index of ArrayList
    // as a good programing practice : Encapsulation
    private int findContact(Contact contact) {

        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {

        // we will loop through all the record and  will extract the name out
        // so we will compare the name that is passed to every name in the list
        // Finally we will return the index position if we find the same name

        for (int i = 0; i < this.myContacts.size(); i++) {

            // fetching every contact in the ArrayList at every position by doing iteration
            Contact contact = this.myContacts.get(i);

            //test for comparision of names
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }

        return -1;
    }

// method 2 : update a contact in the Contact ArrayList

    public boolean updateContact(Contact oldContact, Contact newContact) {

        // checking if contact exists
        int foundPosition = findContact(oldContact);

        //
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }

        // so that an existing contact don get updated
        else if (findContact(newContact.getName()) != -1){

            // that means we have already got a contact with the same name

            System.out.println("contact with name "+newContact.getName()+" already exists.");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }


    // method 3 : searching a contact in the Contact ArrayList

    public String queryContact(Contact contact) {

        if (findContact(contact) >= 0) {
            return contact.getName();
        }

        return null;
    }

    // another overloaded version of queryContact
    public Contact queryContact(String name) {

        int position = findContact(name);

        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    // method  4 : delete a contact in the Contact ArrayList

    public boolean removeContact(Contact contact) {

        int foundPosition = findContact(contact);

        //
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }

        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted.");
        return true;

    }

    // printContact method
    // we made the right decision to put the code here
    // because it was related to the MobilePhone

    public void printContacts() {

        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {

            System.out.println((i + 1) + "."
                    + this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }

}
