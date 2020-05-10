package com.navjeet;

public class Dog extends Animal {

    // own state specific to Dog Class
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;


    // refactoring Dog constructor

//    public Dog(String name, int size, int weight) {
//        super(name, 1, 1, size, weight);
//    }

    public Dog(String name,  int size, int weight,
               int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    public void chew(){
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    public void walk(){

        System.out.println("Dog.walk() called");
        move(4);
    }

    public void run(){

        System.out.println("Dog.run() called");
        move(15);
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }

    public void moveLegs(int speed){
        System.out.println("Dog.movelegs() called");
    }
}
