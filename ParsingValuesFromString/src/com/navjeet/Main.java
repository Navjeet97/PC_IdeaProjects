package com.navjeet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String numberAsString = "2019.725";
        System.out.println("numberAsString = " +numberAsString);

       //int number = Integer.parseInt(numberAsString);
        double number = Double.parseDouble(numberAsString);
        System.out.println(number);


        numberAsString += 1;
        number += 1;
        System.out.println(numberAsString);
        System.out.println(number);


    }
}
