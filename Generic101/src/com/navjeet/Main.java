package com.navjeet;

public class Main {

    public static void main(String[] args) {
        // write your code here

        FootballPlayer nupur = new FootballPlayer("nupur");
        BaseballPlayer navi = new BaseballPlayer("navi");
        SoccerPlayer noor = new SoccerPlayer("noor");

        Team<FootballPlayer> warriors = new Team<>("warriors");
        warriors.addPlayer(nupur);
        //warriors.addPlayer(navi);
        //warriors.addPlayer(noor);

        System.out.println(warriors.numPlayer());

        Team<BaseballPlayer> baseballTeam = new Team<>("T-warrior");
        baseballTeam.addPlayer(navi);

//        Team<String> brokenTeam = new Team<>("this won't work");
//        brokenTeam.addPlayer("no-one");

        Team<SoccerPlayer> soccerTeam = new Team<>("this won't work");
        soccerTeam.addPlayer(noor);


        Team<FootballPlayer> warriorUSA = new Team<>("warriorUSA");
        FootballPlayer ryan = new FootballPlayer("ryan");
        warriorUSA.addPlayer(ryan);

        Team<FootballPlayer> warriorAUS = new Team<>("warriorAUS");
        Team<FootballPlayer> warriorCAN = new Team<>("warriorCAN");

        warriorAUS.matchResult(warriorCAN,1,0);
        warriorAUS.matchResult(warriors,3,8);

        warriors.matchResult(warriorCAN,2,1);
      //  warriors.matchResult(baseballTeam,1,1);

        System.out.println("Rankings!!");
        System.out.println(warriors.getName() +": "+warriors.ranking());
        System.out.println(warriorAUS.getName() +": "+warriorAUS.ranking());
        System.out.println(warriorCAN.getName() +": "+warriorCAN.ranking());
        System.out.println(warriorUSA.getName() +": "+warriorUSA.ranking());

        System.out.println(warriors.compareTo(warriorUSA));
        System.out.println(warriors.compareTo(warriorCAN));
        System.out.println(warriorUSA.compareTo(warriors));
        System.out.println(warriorUSA.compareTo(warriorCAN));



    }
}
