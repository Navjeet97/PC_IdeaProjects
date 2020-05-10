package com.navjeet;

import java.util.Arrays;
import java.util.Scanner;

// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] intArray = getIntegers(4);

        printArray(intArray);

        System.out.println("Lets sort the integers passed");
        int[] sorted = sortIntegers(intArray);
        printArray(sorted);

        Arrays.copyOf(intArray,intArray.length);

    }


    // Method 1 - To ask for a dynamic Array on runtime & initialize it from the values passed by the calling program
    public static int[] getIntegers(int number) {

        System.out.println("Please enter " + number + " integer values \r");

        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {

            values[i] = scanner.nextInt();

        }

        return values;
    }


    // Method 2 - Print out all the elements of an Array

    public static void printArray(int[] array) {

        System.out.println("====================");
        System.out.println("Printing all the elements of an Array: \r");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " entered was - " + array[i]);
        }

        System.out.println("Array printing finished... ");
        System.out.println("====================");

    }


    // Method 3 - sorting elements of the array passed or sorting a list of integers, in descending order
    public static int[] sortIntegers(int[] array) {
//        int[] sortedArray = new int[array.length];

        // copying contents from old Array to the new Array
//        for (int i = 0; i < array.length; i++) {
//            sortedArray[i] = array[i];
//        }
        int[] sortedArray = Arrays.copyOf(array, array.length);
//        Arrays.sort(array);
//        int[] newArray = new int[array.length];
//        for (int i = array.length - 1 ; i >= 0 ; i++){
//        int count = 0;
//            newArray[count] = array[i];
//            count++;
//        }

        // there are vanities of ways to sort the elements
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {

                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }

        }

        /*Arrays.sort(array);

        for ( int k =0 ; k < array.length ; k++) {

            for (int i = sortedArray.length ; i > 0; i--) {

                sortedArray[i - 1] = array[k];
            }
        }*/
        return sortedArray;
    }


}
