package com.navjeet;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        // creating a Bank  - it's object
        Bank bank = new Bank("HDFC");

        // Adding Branch to Bnak
       if (bank.addBranch("Pune")){
           System.out.println("Pune branch is created");
       }

        // Adding new Customers to branch
        bank.addCustomer("Pune", "Navjeet", 200.57);
        bank.addCustomer("Pune", "Nupur", 150.11);
        bank.addCustomer("Pune", "Navnoor", 350.0);

        // another branch and its new Customers
        bank.addBranch("Jalandhar");
        bank.addCustomer("Jalandhar","Jagtar", 800.89);
        bank.addCustomer("Jalandhar","Drake", 1000.0);

        // adding more transaction for above customers
        bank.addCustomerTransaction("Pune", "Navjeet",30.5);
        bank.addCustomerTransaction("Pune", "Navjeet",10.0);
        bank.addCustomerTransaction("Pune", "Nupur",2.5);

        // lets view list of customers in a branch
        bank.listCustomers("Pune",false);
        System.out.println();
        bank.listCustomers("Pune",true);

        System.out.println();
        bank.listCustomers("Jalandhar",true);


        if (!bank.addCustomer("Goa","Jackie",100.0)){
            System.out.println("\nError Goa Branch does not exist");
        }

        if (!bank.addCustomer("Jalandhar","Jackie",100.0)){
            System.out.println("\nError Goa Branch does not exist");
        }

        bank.listCustomers("Jalandhar",false);

        if (!bank.addCustomerTransaction("Pune","Gupta",50.50)){
            System.out.println("\nCustomer does not exist in branch");
        }

        if (!bank.addCustomer("Pune","Navjeet",100.0)){
            System.out.println("\nCustomer already exist");
        }


    }
}
