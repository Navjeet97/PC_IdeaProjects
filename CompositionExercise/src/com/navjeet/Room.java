package com.navjeet;

public class Room {

    private int wall;
    private String color;

    private Furniture theFuurniture;
    private Gadgets theGadgets;

    public Gadgets getTheGadgets() {
        return theGadgets;
    }

    public void roomMethod(){
        System.out.println("Inside room method");
    }


}
