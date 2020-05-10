package com.navjeet;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        player.fullName ="Navjeet";
        player.health = 20;
        player.weapon = "Gun";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remining health = "+player.healthRemaining());

        damage = 11;

        // if we do below settings
        // taking the control out of player class, i.e its special working - loseHealth method
        // think of it as a cheat code
        player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remining health = "+player.healthRemaining());


        // loseHealth method - is managing the whole process
        // has all formulas, also have a special message - Player Knocked out


        System.out.println();
        System.out.println();
        EnhancedPlayer player1 = new EnhancedPlayer("drakeNavi", 50,"lightning sword");
        System.out.println("Initial health is "+player1.getHealth());


        System.out.println();
        System.out.println();
        Printer printer = new Printer(50,true);
        System.out.println("initial page count = "+printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("pages printed was " + pagesPrinted +
                " new total count for printer = "+printer.getPagesPrinted());


        System.out.println();
        System.out.println();
        Printer printer2 = new Printer(50,false);
        System.out.println("initial page count = "+printer.getPagesPrinted());
        int pagesPrinted2 = printer.printPages(4);
        System.out.println("pages printed was " + pagesPrinted2 +
                " new total count for printer = "+printer.getPagesPrinted());


    }
}
