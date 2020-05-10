package com.navjeet;

public class SecondsAndMinutes {

    public static String getDurationString(int minutes, int seconds){

        if ((minutes < 0) || (seconds < 0 || seconds >59)){
            return "Invalid value";
        }
        int totalSeconds = (minutes * 60 ) + seconds;
        int hours = totalSeconds / 3600;
        int remaningMinutes = (totalSeconds % 3600 ) / 60;
        int remainingSeconds = totalSeconds % 60;

        return hours+"h "+remaningMinutes+"m "+remainingSeconds+"s";
    }

    public static String getDurationString(int seconds){

        if (seconds<0){
            return "Invalid value";
        }
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        String result = getDurationString(minutes,remainingSeconds);


        return result;
    }





}
