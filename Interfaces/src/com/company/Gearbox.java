package com.company;

public class Gearbox {

  private boolean clutchIsIn;

  public void operateClutch(String inOrOut){

      this.clutchIsIn = inOrOut.equalsIgnoreCase("in");
  }

    /*
It is 1 way of implementing a particular method to decide
whether clutch is in or out
probably this won't be the best way to do it
it is little bit untidy
*/

// if we decide that we want to change the parameter
// from String to boolean

    public void operateClutch(boolean inOrOut){

        this.clutchIsIn = inOrOut;
    }

}


//Interface is actually a commitment, a contract
// that the method's signatures, variables in the interface,
// constants defined will not change
// So its code isn't going to change
// and you're not gonna be breaking code anywhere








