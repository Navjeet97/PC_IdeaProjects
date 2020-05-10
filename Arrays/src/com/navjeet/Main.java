package com.navjeet;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //declare
        int[] myVariable;

        //construct
        myVariable = new int[10];

        //or

        int[] myIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
        myIntArray[2] = 67;
        myIntArray[0] = 45;

        // Or

        System.out.println(myIntArray[0]);
        System.out.println(myIntArray[6]);
        System.out.println(myIntArray[2]);

        int[] myIntegerArray = new int[25];
        // using for loop to initialize
        for (int i = 0; i < myIntegerArray.length; i++) {
            myIntegerArray[i] = i * 10;
        }


        // calling method and passing the entire array
        printArray(myIntegerArray);

//        for (int i = 0; i< myIntegerArray.length ; i++){
//            System.out.println("Element "+ i +" value is "+myIntegerArray[i]);
//        }

        Arrays.toString(myIntArray);




    }

    // method is aceepting an array as argument
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " value is " + array[i]);

        }
    }
}
