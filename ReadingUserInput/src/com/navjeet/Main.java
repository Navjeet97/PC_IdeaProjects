package com.navjeet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your year of birth");
        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            int age = 2019 - yearOfBirth;

            if (age >= 0 && age <= 100) {
                System.out.println("Your name is " + name);
                System.out.println("Your are " + age + " years old");
            } else {
                System.out.println("Invalid year of birth");
            }
        }else  {
            System.out.println("unable to parse year of birth");
        }

//        System.out.println("Enter your name");
//        String name = scanner.nextLine();
//        System.out.println("enter the city and state where you live");
//        String cityState = scanner.nextLine();
//        System.out.println("Your name is - "+name+" and you live in "+cityState);


        scanner.close();

    }
}
