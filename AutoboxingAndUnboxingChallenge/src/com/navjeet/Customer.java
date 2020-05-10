package com.navjeet;

import java.util.ArrayList;


public class Customer {

    // fields
    private String name;
    private ArrayList<Double> transactions ;

           // = new ArrayList<Double>();

    // constructor

    // as both customer name and initial amount
    // is need to create Customer (it's object)
    // so using both these fields as customer argument

    public Customer(String name, double initialAmount) {

        this.name = name;

        // initializing the ArrayList
        // because i need to initialize this transactions member too

        // so this transactions seems to be a wrapper for all transaction type

        // firstly initializing the ArrayList
        // and adding a item later to it in subsequent statement

        this.transactions = new ArrayList<Double>();

        // java will take care of autoboxing here
        // as the variable passed is of primitive type

        addTransaction(initialAmount);

    }


    // method - adding a transaction : adding values to the ArrayList
    // so transactions is having different transaction types
    // - deposit, withdrawal etc..
    public void addTransaction(double amount) {

        // lets add more validations as Tim told
        // checking transaction is acceptable range

        // auto coxing is being done by java itself
        this.transactions.add(amount);

    }

    // getters - to be needed by other classes to get values of member variables
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }


    // factory method - adding a customer (to create without instantiation)
    // Do i need this in this challenge ??
   public static Customer addCustomer(String name, double initialAmount){

       return new Customer(name, initialAmount);
   }

//


}
