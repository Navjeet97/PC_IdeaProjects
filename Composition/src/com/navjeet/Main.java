package com.navjeet;

public class Main {

    public static void main(String[] args) {

        Dimension dimensions = new Dimension(13 ,13,2 );
        Case theCase = new Case("Mac2019", "Apple","240V",dimensions);

        // also created an instance of the class without using the variable
        Monitor theMonitor = new Monitor("2019Mac","apple",
                13, new Resolution(2500,1900));

        Motherboard theMotherboard = new Motherboard("intel-i7","intel",
                4,6,"v2.44");

        PC thePC = new PC(theCase,theMonitor,theMotherboard);

//        thePC.getMonitor().drawPixelAt(1500 ,1200,"red");
//        thePC.getMotherboard().loadProgram("Mac OS X");
//        thePC.getTheCase().presPowerButton();
        thePC.powerUp();





    }
}
