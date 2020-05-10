package com.navjeet;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        // test the reverse method
        // print both arrays - reversed & non-reversed

        int[] array = new int[]{2, 5, 8, 13, 19, 25};
        System.out.println("Array          = "+Arrays.toString(array));
        reverse(array);

        System.out.println("Reversed Array = "+Arrays.toString(array));



    }

    // method will reverse the elements of the array

    private static void reverse(int[] array) {


        // swap the elements of the array
        // 1st element is swapped with last one, and so on...

       //int[] reverseArray = new int[array.length];

//        for (int i = 0; i < array.length ; i++){
//            System.out.println("Element "+i+" = "+array[i]);


   /*         for (int j = array.length - 1 ; j >= 0 ; j-- ){

                reverseArray[j] = array[i];
                System.out.println("Reverse Array Element "+j+" = "
                        +reverseArray[j]);

            }*/


        int maxIndex = array.length - 1 ;
        int halfLength = array.length / 2 ;

        for (int i = 0 ; i < halfLength ; i++){
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }




    }
}
