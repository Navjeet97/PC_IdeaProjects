package com.navjeet;

public class BankAccount {

    private int acountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(){
        this(58908 ,
                200.45,"Kabir Singh",
                "kabir@preetisikka.com","020-554-165");
        System.out.println("Empty Constructor called");
    }

    public BankAccount(int acountNumber, double balance, String customerName, String email, String phoneNumber) {
        System.out.println("Constructor with all the parameters called");
        this.acountNumber = acountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
      this(999, 0.50,customerName,email,phoneNumber);
    }

    public int getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(int acountNumber) {
        this.acountNumber = acountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double deposit(double fund){

        this.balance += fund;

        return this.balance;
    }

    public double withdraw(double fund ){

        if (this.balance >= fund){
            this.balance -= fund;
            return this.balance;
        }else{

            return -1;
        }


    }


}
