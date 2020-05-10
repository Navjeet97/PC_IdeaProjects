package com.navjeet;

public class Main {

    public static void main(String[] args) {


        System.out.println(sumDigits(-9));
        System.out.println(sumDigits(0));
        System.out.println(sumDigits(32123));


        System.out.println();
        System.out.println("Tim's version... ");
        System.out.println(sumDigitsTim(147));



    }

    public static int sumDigits(int number){

        if (number < 10){
            return -1;
        }

        int sum = 0 ;
        do{

            int leastSignificantDigit = number % 10 ;
            number = number / 10 ;
            sum += leastSignificantDigit ;
            if ( number == 0){
                break;
            }

        }while( ! (number % 10 == 0));

        return sum;
    }

    public static int sumDigitsTim (int number){


        if (number < 10){
            return -1;
        }

        int sum = 0;

        while (number > 0 ){

            int digit = number % 10 ;
            sum += digit ;
            number /= 10 ;
        }

        return sum;

    }



}
