package com.navjeet;

import java.util.ArrayList;

// Lecture 101 - Generics
// In next lecture we will create our own generic class
public class Main {


    public static void main(String[] args) {

        // ArrayList example that does not use Generics
        // Create an Array populated with integers
        // and a method that prints the contents of the ArrayList doubled
        //  ArrayList items = new ArrayList();

        // ArrayList<Integer> items = new ArrayList();
        // So we have specified that this the type of
        // data that we will using in our ArrayList

        // But its still saying that it is an unchecked assignment
        //ArrayList<Integer> items = new ArrayList<Integer>();
        // This get rids of that warning

        // But IntelliJ is saying
        // Explicit type argument Integer can be replaced with <>
        // if using java 1.7 or above
        ArrayList<Integer> items = new ArrayList<>();
        // Now IntelliJ reports a tick
        // Because adding a type on RHS is un necessary
        // because Java got enough info at LHS
        // so we could even delete <> or <Integer> altogether
        // Recommend to do whatever takes to get rid of the warnings

// if using only <> (diamond)gives you error
        // then set the appropriate language level up
        // File -> Project Structure -> Set Java SDK to 8

        // So by telling ArrayList what type of objects
        // we wanted it to hold
        // The program will now fail to compile
        // if we try to add another type



// adding an integer to the ArrayList
        // it is using Autoboxing automatically
        items.add(1);
        items.add(2);
        items.add(3);
        //items.add("Navjeet");
        items.add(4);
        items.add(5);

        printDoubled(items);

    }

    // private static void printDoubled(ArrayList n) {
    private static void printDoubled(ArrayList<Integer> n) {

        // Notice we have used the Object here
        // Because we didn't actually specified what the object was above
        // (like we used to do ArrayList Study)
        for (Object i : n) {

            // we have to cast this as an integer
            // otherwise error will say Operation * cannot be applied to Objects
            // we have to sort of tell Java
            // what type of object is actually in the ArrayList

            System.out.println((Integer) i * 2);
// we can also get rid of the cast

        }

        // Java is actually handling the auto boxing automatically for us
        // It knows how to convert back from Integer to an int
        for (int i : n) {
// we can also get rid of that cast
            System.out.println( i * 2);
        }

        // But technically the ArrayList that we have created in this Exercise
        // can contain anything, any type of object
        // not just integers like we used here

        // That actually more than a minor inconvenience
        // because it also completely breaks the compiler's type checking
        // Ex.  items.add("Navjeet"); will cause a runtime exception
        // due to the * operation not being valid for String
        // and also cannot be converted into an integer
        // but no compilation error

        // So the problem is that it is not showing this issue until runtime

        // Goto View -> Tool Windows -> Messages after this error
        // It says - java uses unchecked or unsafe operations
        // This is Java's way of saying that there is
        // a problem with our code

        // Java Compiler and IntelliJ by default
        // knows how to provide these warnings
        // because they are actually looking at your code
        // They know that ArrayList is a generic type
        // And we are using it without specifying a type parameter
        // i.e. using without Generics

        // We have not ArrayList what type of objects
        // we will be storing in the ArrayList

        // So ArrayList used here is of raw type
        // Prior to Java 1.5 this was the only way to code
        // There was no generics
        // Java 1.5 introduced them
        // So they have left this old way of doing things in
        // purely for backward compatibility
        // with code written from previous versions

        // Lesson learned : Almost never use these raw types any more
        // because we can crash it quite easily

        // Type safety is so easy to implement these days
        // in current versions of Java


        // So when we actually provide a type parameter
        // to a Generic Type
        // This is called Parameterized type

        // We specify the type using angle brackets

        // Making changes to our ArrayList code
        // It will immediately throw error while adding a String

    }


}

// Generics
// - What are Generics?
// Why would we want to use them ?

// Just as we can create methods that arguments in JAVA
// and we replace the parameters that we declared from the method

// Generics allow us to create classes, Interfaces and methods
// that take types of parameters called - Type Parameters
// They are different to other parameters