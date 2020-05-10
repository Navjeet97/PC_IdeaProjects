package com.navjeet;

import java.util.*;

public class Theatre {

    // variable to capture the Theater's name
    private final String theatreName;

    // list to contain all the seats present in the Theatre
   // private List<Seat> seats = new ArrayList<>();
   // private List<Seat> seats = new LinkedList<>();
   //  private Collection<Seat> seats = new ArrayList<>();
    //  private Collection<Seat> seats = new LinkedList<>();
    // private Collection<Seat> seats = new HashSet<>();
 // private Collection<Seat> seats = new LinkedHashSet<>();
  //  private Collection<Seat> seats = new Vector<>();
    //private Collection<Seat> seats = new TreeSet<>(); //--- don't works w/o implementing Comparable
  // private Collection<Seat> seats = new HashMap<>();  --- don't works

    // making list public for testing purpose..
    public List<Seat> seats = new ArrayList<>();

    // Theatre constructor
    public Theatre(String theatreName, int numRows, int seatsPerRow) {

        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row ='A' ;row <= lastRow; row++ ){
            for(int seatNum = 1; seatNum<= seatsPerRow; seatNum++){
                Seat seat = new Seat(row +String.format("%02d",seatNum));
                seats.add(seat);
            }
        }
    }

    // getter
    public String getTheatreName() {
        return theatreName;
    }

    // get list of seats in Theatre
    public  void getSeats(){
        for (Seat seat : seats){
            System.out.print(seat.getSeatNumber()+" ");
        }
    }

    // reserve seats method in Theatre : uses brute-force search
//    public boolean reserveSeat(String seatNumber){
//        Seat requestedSeat = null;
//        for (Seat seat :seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//           if (requestedSeat == null){
//               System.out.println("There is no seat "+seatNumber+" in the Theatre");
//               return false;
//           }
//
//        return requestedSeat.reserve();
//    }

    // reserve Seats in theatre
    // but using Collection's binary search method
//    public boolean reserveSeat(String seatNumber){
//        Seat requestedSeat = new Seat(seatNumber);
//       // not works with a generic collection
//        // because binary search is specific method foe a List here
//        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
//
//        if (foundSeat>=0){
//            return seats.get(foundSeat).reserve();
//        }
//        else {
//            System.out.println("There is no seat "+seatNumber+" in "+this.theatreName+" theatre");
//            return false;
//        }
//
//    }

    // actual java's binary search ditto logic
    public boolean reserveSeat(String seatNumber){

        int low = 0;
        int high = seats.size()-1;

        while (low<=high){
            System.out.print(".");
            int mid = (low +high)/2;
            Seat midVal = seats.get(mid);

            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp<0){
                low = mid+1;
            }else if (cmp > 0){
                high=mid-1;
            }else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat "+seatNumber+" in "+this.theatreName+" theatre");
        return false;

    }

    // Inner Class : Seat
  //  private class Seat implements Comparable<Seat>{

    // making class public for testing purpose... not ideal way though in programming to make inner class public
    public class Seat implements Comparable<Seat>{
      private final String seatNumber;
      private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

       // get seat number
        public String getSeatNumber() {
            return seatNumber;
        }

        // reservation of seat - leveraging a brute-force search
        public boolean reserve(){
            if (!this.reserved){
                this.reserved=true;
                System.out.println("Seat "+seatNumber+" reserved.");
                return true;
            }
            else{
                return false;
            }
        }

        // cancel a reserved seat
        public boolean cancel(){
         if (this.reserved){
             this.reserved = false;
             System.out.println("reservation of seat "+seatNumber+" is cancelled");
             return true;
         }  else{
             return false;
         }
        }

        @Override
        public int compareTo(Seat seat)  {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }




}
