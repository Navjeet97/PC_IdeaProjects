package com.navjeet;

public class Main {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount();
        acc.setAcountNumber(123);
        acc.setBalance(1100.50);
        double newBalance = acc.deposit(500);
        System.out.println("New balance : "+newBalance);

        double afterWithdrawl = acc.withdraw(1500);
        if (afterWithdrawl == -1){
            System.out.println("Insufficient funds");
        }else{
            System.out.println("Balance after withdrawl = "+afterWithdrawl);
        }


        BankAccount bobAccount = new BankAccount
                (12345, 0.00, "Bob"
                        , "bob@abc.com", "020- 34545-5656");

        System.out.println(bobAccount.getBalance());
        System.out.println(acc.getCustomerName());

        BankAccount timAccount = new BankAccount("Tim",
                "tim@alph.in","020-234-456");
        System.out.println(timAccount.getAcountNumber());


        System.out.println();
        System.out.println("VipCustomer code...");
        VipCustomer tim = new VipCustomer();
        VipCustomer mary = new VipCustomer("Mary",50000);
        VipCustomer garry = new VipCustomer("Gary Sandhu",
                100000,"garry@abc.com");

        System.out.println(tim.getName());
        System.out.println(mary.getCreditLimit()+" email - "+mary.getEmailAddress());
        System.out.println(garry.getCreditLimit());

    }
}
