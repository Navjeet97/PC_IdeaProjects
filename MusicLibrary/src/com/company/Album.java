package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;

        // initializing ArrayList inside Constructor
        this.songs = new ArrayList<Song>();
    }

    // No getters as of now ?? Is it to gain higher level of encapsulation??

    // Lets add some functionality : Creating methods

    // method 1: Add a song to Album
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }

        return false;
    }

    // private method : to find a song in the album
    private Song findSong(String title) {

        // introducing for each loop : alternative way to go through a list of entries in Java
        // instead of using putting i = 0 ; i < list.size() ; i++
        // What this does is - it goes through and creates a variable ( here checkedSong) for every entry that's actually in our list

        // It is equivalent of normal while iterations where we go through and increment a variable i, i++ and do a test
        // for .get(i), so on and so forth. So this for each is actually a shortcut for it - java probably internally does the same code
        // But this for each code is far easier to read

        for (Song checkSong : this.songs){
            if (checkSong.getTitle().equals(title)){
                return checkSong;
            }
        }
        return null;
    }


    // we will also add songs to a playlist i.e. addToPlaylist() method
    // we are going to add the songs that are part of this album to this playlist
    // we will pass the playlist as a parameter, which is a LinkedList

    // method 2: Adding an Album song to a Playlist
    // argument : passing the trackNumber + playlist name

    // Normally we will hide the index from the users of our classes
    // But songs in a Album do have a track number
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){

        // track number starts from 1
        // creating a variable to accommodate zero based indexes
        int index = trackNumber - 1;

        // the only check we need here is to validate that trackNumber passed exist in the Album

        //if ( (index >= 0) && (index <= this.songs.size()) ){
        // making correction
        if ( (index >= 0) && (index < this.songs.size()) ){


            playlist.add(this.songs.get(index));
            return true;

        }
        System.out.println("This Album does not have a track "+trackNumber);
        return false;
    }

    // overload method : addToPlaylist
   public boolean addToPlaylist(String title, LinkedList<Song> playlist){

        Song checkedSong = findSong(title);
        if (checkedSong != null)
        // i.e. we successfully found the song
        {
           playlist.add(checkedSong);
           return true;
        }
       System.out.println("The song "+title+" is not in this album");
        return false;
   }

    // We could have also done like - add to playlist by using actual Song object itself

    // We have add this method in the Album class
    // because we are looking at at the Album when we are actually creating the playlist

    // But it would be valid as well, if you decide to add the mechanism to add a song to the playlist
    // , if you had that code in the actual Song class


}
