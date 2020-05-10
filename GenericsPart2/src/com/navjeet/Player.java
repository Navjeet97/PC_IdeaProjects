package com.navjeet;

public abstract class Player {

    // player's name
    private String name;

    // constructor
    public Player(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }
}

// Now we will create 3 types/ 3 classes
// - a Baseball Player. a football player, soccer player

// There's nothing generic about those at this stage
// Next we create a Team Class
// with ability to actually add Players