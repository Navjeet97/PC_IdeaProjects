package com.navjeet;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("myintValue = "+myIntValue);
        System.out.println("anotherIntValue = "+anotherIntValue);

        System.out.println();
        anotherIntValue++;
        System.out.println("after change, myIntValue = "+myIntValue);
        System.out.println("after change anotherIntValue = "+anotherIntValue);

        System.out.println();
        System.out.println("Refernce Types...");

        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;

        System.out.println("Address of myIntArray = "+myIntArray);
        System.out.println("Address of anotherArray = "+anotherArray);

        System.out.println("elements of myIntArray   :   "+Arrays.toString(myIntArray));
        System.out.println("elements of anotherArray :   "+Arrays.toString(anotherArray));

        System.out.println();
        anotherArray[0] = 17;

        System.out.println("after change anotherArray[0] = 17;, elements of myIntArray   :   "+Arrays.toString(myIntArray));
        System.out.println("after change anotherArray[0] = 17;, elements of anotherArray :   "+Arrays.toString(anotherArray));

        //anotherArray = new int[]{1,2,3,4,5};

        modifyArray(myIntArray);

        System.out.println("after modify , elements of myIntArray   :   "+Arrays.toString(myIntArray));
        System.out.println("after modify , elements of anotherArray :   "+Arrays.toString(anotherArray));


    }


    private static void modifyArray(int[] array){


        array[0] = 2;

        array = new int[] {1,2,3,4,5};



    }



}
