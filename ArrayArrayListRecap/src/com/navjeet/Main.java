package com.navjeet;

import java.util.ArrayList;

class IntClass {

    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {


        String[] strArray = new String[10];
        int[] intArray = new int[10];


        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

        // we can't do
        // error : type argument cannot be of primitive type
        // ArrayList<int> intArrayList = new ArrayList<int>();

        // the below code will work if we want to create ArrayList of some primitive data types
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));


        // there is an easier way to do it : AutoBoxing

        Integer integer = new Integer(5);
        Double dVal = new Double(1.256);

        ArrayList<Integer> iArr = new ArrayList<Integer>();

        // assigning some values to this array list
        for (int i = 0 ; i < 10 ; i++){

            iArr.add(Integer.valueOf(i));
        }

        //
        for (int i = 0 ; i < 10 ; i++){

            System.out.println(i +" -> " +iArr.get(i).intValue());
        }


        // Java handling autoboxing and unboxing for us

        Integer myIntValue = 56;

        // or
        Integer val1 = Integer.valueOf(56);

        int myInt = myIntValue;

        // or
        int val2 = myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0 ; dbl < 10.0 ; dbl += 0.5){
          //  myDoubleValues.add(Double.valueOf(dbl));

            // lets do shortcut
            myDoubleValues.add(dbl);
        }

        for (int i =0 ; i<myDoubleValues.size(); i++){

          //  Double value = myDoubleValues.get(i).doubleValue();

            // lets do a shortcut
            Double value = myDoubleValues.get(i);

            System.out.println(i + " -> "+value);
        }






    }
}


