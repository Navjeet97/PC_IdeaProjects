package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Navi", 143.56);
        Customer anotherCustomer ;

        // Java just saved the memory address
        // does not create a separate object
        anotherCustomer = customer;
        anotherCustomer.setBalance(180.0);
        System.out.println("Balance for customer "+customer.getName()+" is "+customer.getBalance());


        // As Java does not make use of pointer
        // in other words we cannot actually point to these objects directly

        // Ex. 2
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(2);
        intList.add(3);
        intList.add(5);

        for (int i = 0; i< intList.size();i++){
            System.out.println(i+": "+intList.get(i));
        }

        intList.add(1,7);

        System.out.println();

        for (int i = 0; i< intList.size();i++){
            System.out.println(i+": "+intList.get(i));
        }

        // so other entries are moving down to make space for the new add operation at that index
        // it is not big deal for  computer processing time when dealing with small arrays
        // imagine array of thousands, million of existing items,
        // because there are so many elements to process that add() method i.e. more work - lot of resources needed
        // similarly removing an item from array, all the other items have to move up to fill the gap
        // So here there is lot of manipulations by the computer required


        // Linked List is an alternative to an arrays
        // really usefull in some situations
        // working - it stores the link to the next item in the List, along with the data
        // : is held by each item of Linked List

        // How is it better??
        // Linked list is literally iterating the the list of items in it
        // we are starting from 1st one and the code would be checking
        // whether it has anything attached to it.

        // 1. While addition : traditional array would have moved items
        // Here we will onld add an item by linking it ot - back item and next item
        // Its literally changing one or two items at the most, everything else remain at the same position
        // 2. similarly in removal -
        // here because nothing is refering to this removed item anymore
        // removed object/item will be automattically destroyed by Java Garbage Collection
        // So these are functions of the LinkedList









    }
}
