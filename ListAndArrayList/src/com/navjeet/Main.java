package com.navjeet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstrunctions();

        // continue the processing until user decides to exit
        while (!quit) {


            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            // below command to clear the input buffer
            scanner.nextLine();

            // using switch for the choice that is entered by the user
            switch (choice) {
                case 0:
                    printInstrunctions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;

            }


        }

    }


    public static void printInstrunctions() {

        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search an item in the list.");
        System.out.println("\t 6 - To quit the application");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");

        // by nextLine - whatever is typed we are going to add it as an item
        // so it will allow us to enter anything until return is passed
        // so it will take the thing type and to the GroceryList Class
        // this will add it to the ArrayList
        groceryList.addGroceryItem(scanner.nextLine());

    }


    // Refactor 1
    public static void modifyItem() {

     /*   System.out.print(" Enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();*/

        System.out.print("Enter item to modify: ");
        String oldItem = scanner.nextLine();


        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();

        // Arrays start counting from 0
        // but for human readability we actually started the count from 1
        // groceryList.modifyGroceryItem(itemNo-1, newItem);

        groceryList.modifyGroceryItem(oldItem, newItem);

    }


    // Refactor 2
    public static void removeItem() {
      /*  System.out.print(" Enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();*/


        System.out.println("Enter item to delete: ");
        String item = scanner.nextLine();

        // groceryList.removeGroceryItem(itemNo - 1);
        groceryList.removeGroceryItem(item);
    }


    // Refactor 3
    public static void searchItem() {

        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();


        // changing the call to new method created
        // if (groceryList.findItem(searchItem) != null)
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }


    }

    // adding new method
    // copying contents of rrayList and pasting it into another ArrayList and a regular Array
    public static void processArrayList() {

        // method 1 :

        // creating a new ArrayList
        ArrayList<String> newArray = new ArrayList<String>();

        // addAll() method to copy the entire content to the new Array
        newArray.addAll(groceryList.getGroceryList());

        // method 2 :
        // iterating through for loop

        // method 3 : decalring and initializing at the same time
        ArrayList<String> ourArray = new ArrayList<String>(groceryList.getGroceryList());


        // copying contents of an ArrayList to a regular Array
        // method 4 :

        // initializing an array to the same size as an ArrayList - using getter and size() method on ArrayList
        String[] myArray = new String[groceryList.getGroceryList().size()];

        // using toArray() method on ArrayList contents and passing an array to be updated as argument
        myArray = groceryList.getGroceryList().toArray(myArray);




    }


}
