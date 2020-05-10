package com.navjeet;

public class Contact {

    private String name;
    private String phoneNumber;


    // constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        }

        // to print out the information
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // no setters as every time at construction we want to make use of constructor

    // exposing a public static method so that we can create a new contact record
    // this will be very useful when we will be accessing functions built-into mobile phone
    // instead of passing a parameter as name or phone number, we can create a contact record
    // we can create a contact without creating a new separate object

    // method is static so that we don't have to create a new object for this Contact class
    // It is also known as a factory method as well
    public static Contact createContact(String name, String phoneNumber){

        return new Contact(name, phoneNumber);

    }





}
