package com.navjeet;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here

        // read the count from the console
        System.out.println("Please enter some integer values");
        System.out.println("How many integer values you want to enter ?");
         int count = scanner.nextInt();

        // call readIntegers(), pass count as parameter
        int[] array = readIntegers(count);

        System.out.println(Arrays.toString(array));

        // array is returned by the above call


        // call findMin() passing array to get the min value

       int minValue = findMin(array);


        // print the min value

        System.out.println("Minimum value entered is - "+ minValue);
    }

    // how many integers are needed to be entered by the user

    public static int[] readIntegers(int count){

        int[] array = new int[count];

        for (int i = 0; i< count ; i++){

            array[i] = scanner.nextInt();
        }


        return array;

    }


    // logic to find the minimum element in array
    public static int findMin(int[] array){

        int temp;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1 ; i++) {
                if (array[i] > array[i+1]){
                    temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    flag = true;
                }
            }
        }


        return array[0];
    }


}





