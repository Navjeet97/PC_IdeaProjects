package com.navjeet;

import java.util.Scanner;

public class Main {

    // defining static scanner object
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        // we will be creating the below method
        // this method will allow us to type in 5 numbers
        // and will return those 5 numbers in the form of Array
        int[] myIntegers = getIntegers(5);

        // printing values of the array, typed from console in the method call
        for (int i = 0; i< myIntegers.length ; i++){
            System.out.println("Element "+i+", typed value was "+myIntegers[i]);

        }


        System.out.println("The average is "+getAverage(myIntegers));


    }

    // return type of the method is an array
    // it is accepting an integer argument, so that it can accept any number of elements requested by a programmer
    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values: \r");

        // Array is being declared and initialized ( based on number passed )
        int[] values = new int[number];


        // assigning values from Scanner
        for (int i = 0; i < values.length ; i ++){

            boolean checkIntValue = scanner.hasNextInt();

            if (checkIntValue){
                values[i] = scanner.nextInt();
            } else {
                System.out.println("It is not a valid integer value");
            }

        }

        return values;

    }


    // a method accepting an integer array and calculate average of its elements
    public static double getAverage(int[] array){

        int sum = 0;

        for(int i = 0; i< array.length ; i++){

            sum += array[i];
        }

    return  (double) sum / (double) array.length  ;
    }







}
