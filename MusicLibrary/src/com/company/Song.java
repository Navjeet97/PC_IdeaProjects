package com.company;

public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }


    // using toString : to output the content of actual object
    // is part of Java Infrastructure of all Objects i.e. part of Object class
    // default implementation of toString gives - fully qualified name of class @ a number meant to represent the memory
    // , where that particular object is in memory

    @Override
    public String toString() {

        return "Song -> "+this.title +" : "+this.duration;
    }
}
