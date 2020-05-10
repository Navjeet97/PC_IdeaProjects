package com.navjeet;

public class Vehicle {

    private int speed;

    private String operate;

    public Vehicle(int speed, String operate) {
        this.speed = speed;
        this.operate = operate;
    }

    public void handling(String operate){
        System.out.println("Vehicle is operated by - "+operate);
    }

    public void runAt(int speed){
        System.out.println("Vehicle runs at a speed of "+speed);
    }

}
