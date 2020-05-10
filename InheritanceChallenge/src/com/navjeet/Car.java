package com.navjeet;

public class Car extends Vehicle {

    private static String operate = "Steering";

    private int speed;

    private int gears;

    private boolean isAutomatic;

    public Car(int speed, String operate, int speed1, int gears, boolean isAutomatic) {
        super(speed, operate);
        this.speed = speed1;
        this.gears = gears;
        this.isAutomatic = isAutomatic;
    }

    @Override
    public void handling(String operate) {
        super.handling(this.operate);
    }

    @Override
    public void runAt(int speed) {
        super.runAt(this.speed);
    }
}
