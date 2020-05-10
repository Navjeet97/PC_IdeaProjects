package com.navjeet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ten numbers.");


        int sum = 0;
        int n1 = 0;

        for (int i = 1 ; i <= 10 ; i++){
            System.out.println("Entered number #"+i);
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt){
               int number = scanner.nextInt();
                sum += n1;
                //continue;
            }else{
                System.out.println("Invalid number");
                 break;
            }
            scanner.nextLine();
        }

        System.out.println("sum is "+sum);
        scanner.close();





    }
}
