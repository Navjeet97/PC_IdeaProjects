package com.navjeet;

import java.util.ArrayList;

public class Branch {

    // fields
    private String name;
    // to have a separate list of customers for each branch
    private ArrayList<Customer> customers ;
            //= new ArrayList<Customer>();

    // constructor is initializing the String: name and the array list
    public Branch(String name) {
        this.name = name;
        //  initializing the Array List
        this.customers = new ArrayList<Customer>();
    }

    // to show branch name, by other classes
    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // methods

    // method - to add a new Customer and initial amount

    // boolean return type to notify other classes
    // that customer was created successfully in a branch or not

    // will return false if customer was already on file
    public boolean newCustomer(String customerName, double initialAmount) {

        if (findCustomer(customerName) == null)

        // i will create this method later
        // Should I create it in Customer class

        {

            // using add method of ArrayList
            // but i will create a new Customer object

            // commenting Tim's code for while
            // i am thinking if factory method will help us more
            // this.customers.add(new Customer( customerName, initialAmount));

            // let me use factory method instead
            // Will there be any benefit with factory method ??
            // i have not created Customer object, so saved memory

            this.customers
                    .add(Customer.addCustomer(customerName, initialAmount));


            // meaning customer successfully added
            return true;
        }

        // if customer already exists, it won't be added again.
        return false;

    }

    // method - add transaction
    // we will write validation inside it
    // if customer does not exist, we will not add transaction

    public boolean addCustomerTransaction(String customerName,
                                          double amount) {

        Customer existingCustomer = findCustomer(customerName);

        //  if (findCustomer(customerName) != null){

        if (existingCustomer != null) {
            // so something is returned
            // customer is already on file

            // lets grab this existing customer
            // and update it by the amount to the transaction
            // lets put this code before if to do cleanup
            // don't want to call findCustomer twice
            // so will change the if condition too


            // we are executing here the addTransaction method from customer class
            // Tim is telling to go back to this method definition
            // and some validations there
            existingCustomer.addTransaction(amount);

            return true;
        }

        return false;
    }

    // method find customer
    private Customer findCustomer(String customerName) {
        // check the list of customers i.e ArrayList

        for (int i = 0; i < this.customers.size(); i++) {
            // passing Customer getter to ArrayList get method
            // to retrieve some customer object with this name field
            // finally comparing them

            // using equals method instead of ==

            // so retrieving each element at each loop iteration

            Customer checkedCustomer = this.customers.get(i);

            //if (this.customers.get(i).getName().equals(customerName)){

            // lets return the customer object found
            //  return this.customers.get(i);

            // lets do some cleanup
            // we are double processing here, retrieving the customer object twice
            // once to get it with name and second time to return it from the method

            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }


}
