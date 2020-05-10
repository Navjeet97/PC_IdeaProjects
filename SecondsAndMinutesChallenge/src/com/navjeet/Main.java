package com.navjeet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(SecondsAndMinutes.getDurationString
                (100,55));
        System.out.println(SecondsAndMinutes.getDurationString
                (61,0));
        System.out.println(SecondsAndMinutes.getDurationString
                (0,-12));
        System.out.println(SecondsAndMinutes.getDurationString
                (-15));
        System.out.println(SecondsAndMinutes.getDurationString
                (6400));




    }
}
