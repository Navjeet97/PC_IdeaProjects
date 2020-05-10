package com.company;

public interface ITelephone {

    // I stands for interface

    // method signatures only - return type + name + parameters

    // public access modifier is actually redundant for interface methods
    // we are implementing the interface in a class
    // interface exists only to define the methods that must be implemented
    // so private or public is useless in interface
    // we will decide in class whether to make a method - public or private

     void powerOn();
     void dial(int phoneNumber);
     void answer();
     boolean callPhone(int phoneNumber);
     boolean isRinging();


}
