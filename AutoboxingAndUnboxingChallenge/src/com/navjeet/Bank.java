package com.navjeet;

import java.util.ArrayList;

public class Bank {

    // fields
    // name of bank , maybe we won't use it
    private String name;
    private ArrayList<Branch> branches;

    // only declaration, no initialization
    // what will it help us ?
    // so that we won't waste memory
    // and do initialization only when some Bank object is created

    //= new ArrayList<Branch>();

    // constructor
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    // method 1 : Add Branch
    public boolean addBranch(String branchName) {

        Branch existingBranch = findBranch(branchName);

        if (existingBranch == null) {

            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;

    }

    // method 2 : Add customer to a Branch

    // We are having multiple branches
    // every time we add a customer,
    // we need to specify the branch name, customer name and initial transaction

    // same needs to be done for customer transactions

    // It is for- when a customer walks in and wants t0 open account at this branch
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {

        // testing for a valid branch
        Branch branch = findBranch(branchName);
        // if branch name exists, we would like to proceed
        if (branch != null) {

            // so lets add the customer to this particular branch
            // Below Branch method will automatically take care of validation that if this customer already exists
            // i don't have to separately return boolean as below method is already returning boolean
            return branch.newCustomer(customerName, initialAmount);

        }

        return false;
    }


    // method 3 - Adding Transactions for Customer in a Branch
    // we will call that addCustomerTransaction() of Branch class

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {

        // 1. test to see if branch exists
        Branch branch = findBranch(branchName);
        if (branch != null) {

            return branch.addCustomerTransaction(customerName, amount);
        }

        return false;

    }


    // private method to find a branch
    private Branch findBranch(String branchName) {

        for (int i = 0; i < this.branches.size(); i++) {

            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {

                return checkedBranch;
            }
        }

        return null;
    }

    // method 4 - Show a list of Customers in a Branch and optionally a list of their transactions

    // showTransaction variable is set to true if we want a list of transactions
    public boolean listCustomers(String branchName, boolean showTransactions) {

        System.out.println("listCustomer() called...");
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for Branch " + branch.getName() + " : ");

            // we need a list of Customers which are part of this Branch
            // all we need to do is goto Branch class and add getter for the Array List of Customers

            ArrayList<Customer> branchCustomers = branch.getCustomers();

            // lets print the list of customers

            // loop 1 : getting list of all the customers for a branch
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + " [" + (i + 1) + "]");

                // flow control - did customer transactions needed

                // processing optional input - i.e. optionally showing transactions
                if (showTransactions) {
                    System.out.println("Transactions: ");

                    // creating one ArrayList of doubles to store the transaction
                    ArrayList<Double> transactions = branchCustomer.getTransactions();

                    // loop 2:
                    // another loop is needed - because it can be multiple transactions and we want to print each one of them
                    for (int j = 0; j < transactions.size(); j++) {

                        System.out.println("Transaction [" + (j + 1) + "] - Amount: " + transactions.get(j));
                    }
                }

            }

            // returning true before end of if - in which we entered upon when we found a valid branch name
            return true;
        }
        // false - if valid branch name was not found
        else {
            return false;
        }
    }


}
