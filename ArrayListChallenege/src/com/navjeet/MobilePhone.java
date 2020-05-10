package com.navjeet;

// MobilePhone class will have a ArrayList of Contacts
// MobilePhone class will also add a contact, update/modify, delete & query contact i.e it will have all the functionality mentioned above
// Store contact (name & no.) , update/modify contact , remove contact , Query contact ( via name or no.)
// MobilePhone class should be encapsulated. Mobile will do everything through the contact object.
// other class object should have no do direct .int or any .get(i) i.e the inner working of the ArrayList

import java.util.ArrayList;

public class MobilePhone {

    // creating a static ArrayList which will shared by all the instances of MobilePhone class {wrong Impl}
    // I will think later if static is or is not a good idea here...
    // I will not take static object as I am creating a template of MobilePhone
    // which I should allow to be used by different application with their own copy of List of contacts
    private ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    // public method 1 :
    // adding a contact
    public void  addContact(Contacts contact){

        // using add() method of list to add a n element

        contactList.add(contact);

    }

    // finding a contact's position
    // method to be used only by the ArrayList, not to be exposed to other classes
    private int getContactPosition(Contacts contact){

        // using indexOf position to get the lowest index of a contact found in the ArrayList
      //  int position = contactList.indexOf(contact);

        // we will return position if contact found else -1 will be returned
        // no need of a locale variable, so directly returning the position/ integer value
        //
        return contactList.indexOf(contact);

    }

    // public method 2 :
    // find contact method: tell user / program if a particular contact is found or not in the array list
    // searching / querying a contact
    public void findContact(Contacts contact){

        int position = getContactPosition(contact);
        if (position >= 0){
            System.out.println(contact+" is found in the MobilePhone");
        }
        else
        {
            System.out.println(contact+" not found in MobilePhone");
        }

    }

    // public method 3 :
    // remove an existing contact
    public void removeContact(Contacts contact){

        // checking if contact exists in MobilePhone
        int position = getContactPosition(contact);
        if (position >= 0){

            // using remove method of the ArrayList to delete a element
            contactList.remove(contact);

        }
        else{
            System.out.println(contact+" not found. \t Deletion method fails...");
        }

    }


    // public method 4 :
    //   update an existing contact
    public void modifyContact(Contacts contact){

        // checking if contact exists in MobilePhone
        int position = getContactPosition(contact);
        if (position >= 0){

            // using ArrayList built-in method to update element using index and element as arguments
            contactList.set(position,contact);

        }
        else{
            System.out.println("Unable to modify as "+contact+" not found");
        }
    }


    // public method 5 :
    // method need to determine the size of contactList

    public int  sizeOfContactList(){

        // using in-built method size() of ArrayList

        return contactList.size();

    }

    // i will remove above method
    // as i will abstract here the code to print all elements of ArrayList

    public ArrayList<Contacts> printContacts(){

        ArrayList<Contacts> listToPrint = new ArrayList<Contacts>();


        for (int i = 0 ; i < contactList.size() ; i++){

            listToPrint.set(i,contactList.get(i));

        }
        return listToPrint;
    }


    public void printList() {
        System.out.println("You have " + contactList.size() + " items" +
                " in your grocery list");

        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + "." + contactList.get(i));
        }

    }


}


