package com.navjeet;

public class EnhancedPlayer {

    private String name;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {

        // can make other validation on name
        this.name = name;
        // only accepting value of hitPoints between 0-200
        if (health >0 & health <= 100){
            this.hitPoints = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        this.hitPoints = this.hitPoints - damage;
        if (this.hitPoints < 0){
            System.out.println("Player Knocked out");
            // reduce number of lifes reaming for the player
        }
    }

    public int getHealth() {
        return hitPoints;
    }






}
