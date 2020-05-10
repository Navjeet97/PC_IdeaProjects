package com.navjeet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

     // Seat booking system in theatre
        Theatre theatre = new Theatre("Piccadily",8,12);
        //theatre.getSeats();

        // shallow copy
        // copying list/collection objects into a existing one
        // seatCopy list is a shallow copy of the original list
        // use of copy-constructor in ArrayList class below
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);
        printList(theatre.seats);

        seatCopy.get(1).reserve();
        System.out.println("=========Testing to reserve the same seat after reserving in the shallow copy================");
        if (theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        }else{
            System.out.println("Sorry, already reserved");
        }

        Collections.shuffle(seatCopy);
        System.out.println("=========Printing elements of shallow copy after shuffling========");
        printList(seatCopy);
        System.out.println("=========Printing elements of original copy after shuffle in shallow copy===========");
        printList(theatre.seats);
        // the above test proves that both the lists : original and shallow are in fact separate lists


        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Minimum seat number is "+minSeat.getSeatNumber());
        System.out.println("Maximum seat number is "+maxSeat.getSeatNumber());
        // yields same result even if i call min on theatre.seats


        // testing of our bubble sort method created
        sortList(seatCopy);
        System.out.println("========Printing shallow copy after calling bubble sort method==============");
        printList(seatCopy);


       // List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        // above copy constructor does not make successful Collections.copy
        List<Theatre.Seat> newList = new ArrayList<>(100);
        newList.addAll(theatre.seats);

        System.out.println("=====================Printing result of Collections.copy================");
        Collections.copy(newList,theatre.seats);
        printList(newList);
//        System.out.println();
//        if (theatre.reserveSeat("H11")){
//            System.out.println("Please pay");
//        }else{
//            System.out.println("Sorry, seat is taken");
//        }

//        System.out.println();
//        if (theatre.reserveSeat("H11")){
//            System.out.println("Please pay");
//        }else{
//            System.out.println("Sorry, seat is taken");
//        }

    }


    // print list method for code re-usability
    public static  void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat : list){
            System.out.print(" "+seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===================================================================");
    }

    // creating our own sorting algorithm by leveraging Collections.swap
    // implementing bubble sort, in contrast from using Collections.sort merge sorting

    // making generic method - to sort the original theatre.seats list as wells as other similar lists which are copied from it
    public static void sortList(List<? extends Theatre.Seat> list){
        for (int i=0 ; i<list.size()-1;i++){
            for (int j = i+1; j<list.size();j++){
                if (list.get(i).compareTo(list.get(j))>0){
                    Collections.swap(list,i,j);
                }
            }
        }
    }

}
