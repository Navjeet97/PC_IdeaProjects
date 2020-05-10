package com.company;

public class DeskPhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {

        System.out.println("Desk Phone is staring...");
    }

    @Override
    public void dial(int phoneNumber) {

        System.out.println("Now ringing "+phoneNumber);
    }

    @Override
    public void answer() {
        if (isRinging){
            System.out.println("Answering the phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {

      if (phoneNumber == myNumber){
          isRinging = true;
          System.out.println("ring ring..");
      }else{
          isRinging = false;
      }


        return isRinging;
    }

    @Override
    public boolean isRinging() {

        return isRinging;
    }
}

// Although interface relies on all its methods
// even if you don't want a method to use in class
// in that case - implementation can be simple
// in other words overriding that function just to print an error message
// like not supported or not needed etc..

// so you cannot decide that you want to implement only some of the methods
// you have to implement all the methods that are part of the contract