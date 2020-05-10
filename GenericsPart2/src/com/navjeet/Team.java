package com.navjeet;

import java.util.ArrayList;

public class Team {

    // team name
    private String name;

    // we will track : number of games played, numbers won
    // , number tied, number lost

    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    // But in Real Applications - you have to deal with  fixtures.. more fields

    // Create an ArrayList that's using generics for
    // our Player objects
    private ArrayList<Player> members =
            new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

// A method to add Player
    // we are accepting the Parameter of Player
    // which is actually going to enable us with one call
    // to pass a Baseball/Football/Soccer Player

    // We are able to do this because 1. we are using an Abstract Class
    // 2. using Generics here for ArrayList definition
    // for type : Player
    public boolean addPlayer(Player player) {
        // here Player is abstract class definition

        // let's don't add duplicates
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on the team");
        return false;
        }else{
            members.add(player);
            System.out.println(player.getName() + "picked for" +
                    "team "+this.name);
            return true;
        }
    }

    // a getter to return number of Players
public int numPlayers(){
        return this.members.size();
}

}
