package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        // places to visit in Australia
        LinkedList<String> placesToVisit = new LinkedList<String>();

        // dding records
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Camberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");


        printList(placesToVisit);

        // let's insert new record into the LinkedList
        placesToVisit.add(1,"Alice Spring");
        System.out.println();
        printList(placesToVisit);

        // lets remove an element
        placesToVisit.remove(4);
        printList(placesToVisit);

        System.out.println();
        System.out.println();
        System.out.println("Using addInOrder() .. ");

        // Advantages of LinkedList
        // developed a static method below - addInOrder()


        LinkedList<String> placesInOrder = new LinkedList<String>();
         addInOrder(placesInOrder,"Sydney" );
        addInOrder(placesInOrder,"Melbourne" );
        addInOrder(placesInOrder,"Brisbane" );
        addInOrder(placesInOrder,"Perth" );
        addInOrder(placesInOrder,"Canberra" );
        addInOrder(placesInOrder,"Adelaide" );
        addInOrder(placesInOrder,"Darwin" );
        printList(placesInOrder);

        addInOrder(placesInOrder,"Perth" );
        addInOrder(placesInOrder,"Alice Spring" );
        System.out.println("Printing List...");
        printList(placesInOrder);

        System.out.println();
        System.out.println();
        visit(placesInOrder);




}

// there is no current position in ListIterator
    // It hovers between the items that would be returned
    // when you goto next or previous

    // if they have allowed the access to the item
    // at .next() or .previous() in the normal way
    // An error could actually leap to loops in the List
    // It used to be a problem in the past and algorithms have been developed
    // fo detecting and fixing loops in structures like LinkedList
// tortoise and the Hair Algorithm

    // Java has set it up in such a way that it is not going
    // to happen to you
    // but we need to keep track of which direction we are going
    // and allow for the in-between nature of the iterator


public static void visit(LinkedList cities){
    Scanner scanner = new Scanner(System.in);
    boolean quit = false;

    // variable to track the direction
    // And when we will go forward or backwards, we will do a test
    // to check in which direction we are going
    // And we need to set that direction
    boolean goingForward = true;
    ListIterator<String> listIterator = cities.listIterator();
    if (cities.isEmpty()){
        System.out.println(" No cities in the itinerary");
        return;
    }else {
        System.out.println("Now visiting "+listIterator.next());
        printMenu();
    }

    while (!quit){
        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action){
            case 0:
                System.out.println("Holiday over");
                quit = true;
                break;
            case 1:

                // track direction test
                if (!goingForward){
                    if (listIterator.hasNext()){
                        listIterator.next();
                    }
                    goingForward = true;
                }

                // old logic
                if (listIterator.hasNext()){
                    System.out.println
                            ("Now visiting "+listIterator.next());
                }
                else {
                    System.out.println
                            ("Reached the end of the List");
                    goingForward = false;
                }
                break;
            case 2:
                if (goingForward){
                    if (listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    goingForward = false;
                }


                if (listIterator.hasPrevious()){

                    // we are able to use listIterator in sout
                    // because we declared it as of type String
                    System.out.println
                            ("Now visiting "+listIterator.previous());
                }
                else {
                    System.out.println
                            ("Reached start of the List");
                    goingForward = true;
                }
                break;
            case 3:
                printMenu();
        }
    }

}

public static void printMenu(){
    System.out.println("Please select an action:");
    System.out.println("0 - to quit\n"
    +"1 - go to next city\n" +
            "2 - go to previous city\n" +
            "3 - print menu options");
}

// method : printList
    private static void printList(LinkedList<String> linkedList){

        // Concept of Iterator - equivalent to for loop
        // Why is there another looping mechanism ??? - maybe we are aiming for more better efficiency
        // Iterator is another way of accessing and going through all entries
        // that are in a particular Array, ArrayList. LinkedList etc..

        // iterator() is part of LinkedList

        // working - while the element in this LinkedList is pointing to something else
        // means there is atleast one more record to visit
        // when this condition is true - enter while loop
        // i.next() is part of Iterator - alternative way of i++ i.e changing the value of Iterator
        // i.next() also gives the current record and increment
        // hasNext() again asks is there another entry ?
        // Ans as said, .next() is moving to the next entry

        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){
            System.out.println("Now visiting "+i.next());
        }
        System.out.println("=============End=========");

    }


    // adding the cities in alphabetical order
    // Method to - Impose an order
    // every time an entry is added to the LinkedList, we are going to make sure
    // that it is added in an alphabetical order
    // Other good example is to use it - algorithms to workout distances, figuring the most efficient way
    // perhaps add it in that way


    // working - Start with an empty list, fisrt item added is always added at the start
    // While adding second item- we will compare it to the 1st item
    // 3 things can happen - 1. if its duplicate, we will ignore that entry
    // 2. if it sorts alphabetically before the 1st item, we will insert it before 1st item
    // 3. if sorts greater alphabetically,
    // move to next item
    // so we are comparing each time while inserting

    // we will be using something similar to Iterator : called ListIterator


    // adding linked list as argument too for demo purposes
    private static boolean addInOrder(LinkedList<String> linkedList ,String newCity ){

        // using ListIterator than traditional Iterator - for more flexibility
        // when you create this for the 1st time - it automatically goes for the 1st entry
        // listIterator : is made for situations where we are inserting
        ListIterator<String> stringListIterator = linkedList.listIterator();
        // Note about ListIterator is - 1st time you create it
        // It does not point to the 1st record
        // You actually have to use listIteratorObject .next() to go to the 1st item

        // So 1. setup ListIterator and 2. use .next() to point to first record

        while (stringListIterator.hasNext()){

            // compareTo() method
            // return  0 : duplicate - current item/index entry in LinkedList is equal to String passed in compareTo()
            // return >0 : new item alphabet is greater than current item
            // return <0 : new item alphabet is lesser than current item
            int comparision = stringListIterator.next().compareTo(newCity);
            if (comparision == 0){
                // equal, do not add : duplicate
                System.out.println(newCity+" is already included as a destination");
                return false;
            }else if (comparision > 0 ){
                // means new item(returned by next()) should appear before item entered in loop(passed with hasNext())
                // Brisbane -> Adelaide
                // there is one problem : we have already used .next(), so we are already moved to next record
                // so we need to move back to the previous entry again

                // means - go back to previous item / record
               stringListIterator.previous();

               // this String which was passed in the argument
                // item is getting added at previous item's index
                // i think previous item is getting added automatically to its old index+1

               stringListIterator.add(newCity);

               // record was added successfully : lets return true
                return true;
            }else if (comparision < 0){
                // move on to next city, we won't add anything :
                // don't do anything
            }
        }
        // after while loop end
        // we will come here when we have gone through the entire list
        // without finding a suitable point to insert the item
        // So the new item has to go at the end of the list in this case

        // .next() has already run : so its being added after the item to which we were comparing the record
        stringListIterator.add(newCity);
        return true;

    }

    // Java has given us the option to go back in both directions - .next() and .previous()
    // It is because Java has implemented LinkedList as a double link list
    // That is - it stores the refernce to the next item, as well as refernce to the previous item










}
