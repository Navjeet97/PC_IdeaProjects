package com.navjeet;

public class Player {

    // if we do any changes within the class, say changing some variable name
   // public String name;

    // anytime we change the function, name or something in here
    // all applications have to make those changes

    public String fullName;
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        this.health = this.health - damage;
        if (this.health < 0){
            System.out.println("Player Knocked out");
            // reduce number of lifes reaming for the player
        }
    }


    public int healthRemaining(){
        return this.health;
    }




}
