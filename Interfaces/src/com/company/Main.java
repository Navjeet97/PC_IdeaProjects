package com.company;

public class Main {

    public static void main(String[] args) {

        // It is valid to create a reference variable of interface
        // we could also write DeskPhone naviPhone;
        // It depends on circumstances whether to choose
        // reference variable to Interface or Implementation Class

        ITelephone naviPhone;
        naviPhone = new DeskPhone(5531);
        naviPhone.powerOn();
        naviPhone.callPhone(5531);
        naviPhone.answer();

        // we cannot operate new keyword to create an object of Interface
        // if we do it, IntelliJ automatically create a class
        // which is implementing the Interface

        // An Interface is there at an abstract level to tell you
        // what methods are valid and have to be overridden in actual class
        // you can't actually instantiate an interface
        ITelephone object = new ITelephone() {
            @Override
            public void powerOn() {

            }

            @Override
            public void dial(int phoneNumber) {

            }

            @Override
            public void answer() {

            }

            @Override
            public boolean callPhone(int phoneNumber) {
                return false;
            }

            @Override
            public boolean isRinging() {
                return false;
            }
        };


        System.out.println();
        naviPhone = new MobilePhone(123455);
       // naviPhone.powerOn();
        naviPhone.callPhone(123455);
        naviPhone.answer();

//

    }
}
