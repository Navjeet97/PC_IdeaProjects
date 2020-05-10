package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class Main {


    // defining a reference variable to hold different Albums - that will be created in this Application Demo
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {


        Album album = new Album("Drake Essentials", "Drake");

        // Adding Songs to the Album
        album.addSong("How Bout Now", 3.56);
        album.addSong("God's Plan", 3.19);
        album.addSong("One Dance (feat. Wizkid & Kyla)", 2.54);
        album.addSong("Hotline Bling", 4.27);
        album.addSong("In My Feelings", 4.12);
        album.addSong("Started From the Bottom", 3.22);
        album.addSong("Work", 3.25);
        album.addSong("MIA", 5.02);
        album.addSong("SICKO MODE", 4.11);

        // Adding the Album to the ArrayList
        albums.add(album);

        // Creating a new Album - let's reuse the same reference variable album, as the album has been successfully added to the Arraylist
        // but we are creating a a brand new object of Album
        // Any major benefit of using the same reference variable ?? - i don't think so... just readability

        album = new Album("Euphoria", "Enrique Iglesias");
        album.addSong("Tonight", 3.33);
        album.addSong("I like it", 4.17);
        album.addSong("One day At a Time", 4.56);
        album.addSong("Heartbeat (feat. Nicole Scherzinger)", 3.29);
        album.addSong("Dir** Dancer", 2.57);
        album.addSong("Why not me", 3.01);
        album.addSong("Coming Home", 3.44);

        // Adding the Album to ArrayList: albums
        albums.add(album);

        // Adding some some songs to the PlayList ( a LinkedList )
        // And the Albums are stroed in ArrayList

        // Creation and initialisation part
        LinkedList<Song> playlist = new LinkedList<Song>();

        // Addition part - Way 1 : method 1
        albums.get(0).addToPlaylist("MIA", playlist);
        albums.get(0).addToPlaylist("How Bout Now", playlist);
        albums.get(0).addToPlaylist("Hotline Bling", playlist);
        albums.get(0).addToPlaylist("Main Hoon Na", playlist); // Does not exist

        // way 2 : overloaded method
        albums.get(0).addToPlaylist(6, playlist);
        albums.get(0).addToPlaylist(9, playlist);
        albums.get(0).addToPlaylist(10, playlist); // Does not exist

        albums.get(1).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(5, playlist);
        albums.get(1).addToPlaylist(24, playlist); // Does not exist

        // To play Song - Now Playing Song.... Imagine pressing the play button
        play(playlist);


    }


    //  method : Play - To play a Song in the Playlist  -> Play Button
    private static void play(LinkedList<Song> playlsit) {

        // extending play method to accommodate other functionality
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        // as we will go forward when we were at 1st track, later we might travel in both forward and reverse
        boolean forward = true;

        ListIterator<Song> listIterator = playlsit.listIterator();
        if (playlsit.size() == 0) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            // return the current song playing
            // if I have only used next()

            // Java automatically used toString() method overridden in the Song class, even without writing .toString() after.next()
            // System.out.println("Now playing " + listIterator.next());
            // It is because the toString() is the default action
            System.out.println("Now playing " + listIterator.next().toString());

            // Before this challenge we were dealing with Strings, so .next() knew the ListIterator is of type of String
            // and the String returned was used inside the SOPln method
            // In this case, as we are using ListIterator of type Song, so we are explicitly telling here to use toString() method by .next() while returning the object

            // lets print out a menu of options
            printMenu();
        }

        // Adding more code for other functionality
        while (!quit) {
            //System.out.println("Press (button no.)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist ended");
                    quit = true;
                    break;
                case 1:
                    // forward button : next song

                    // logic needed - when backward button was pressed before forward button
                    if (!playlsit.isEmpty()) {
                        if (!forward) {
                            if (listIterator.hasNext()) {
                                // fetching current track playing - doubled nature of LinkedList
                                listIterator.next();
                            }
                            forward = true;
                        }

                        // forward button logic
                        if (listIterator.hasNext()) {
                            System.out.println("Now Playing : " + listIterator.next().toString());
                        } else {
                            System.out.println("Last track of the playlist is reached");
                            // As now we cannot go forward any more, changing forward flag to false
                            forward = false;
                        }

                        break;
                    }
                    else{
                        System.out.println("No action, Playlist is empty");
                        break;
                    }
                case 2:
                    // backward button : previous song

                    // if forward button was pressed before this backward button
                    if (!playlsit.isEmpty()) {
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                // fetching current track playing  - doubled nature of LinkedList
                                listIterator.previous();
                            }
                            forward = false;
                        }

                        //backward button logic
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing : " + listIterator.previous());
                        } else {
                                System.out.println("1st song of the playlist reached");
                                // Cannot go backward now, so changing forward flag to true
                                forward = true;
                        }

                        break;
                    } else{
                        System.out.println("No action, Playlist is empty");
                        break;
                    }
                case 3:
                    // replay button
                    // Take advantage of the fact that - ListIterator is somewhere in the middle, between the previous and the next
                    // 1. It will give us the track we last started playing ,  so we will workout which one to use i.e. which song to replay
                    // 2. we need to know which direction we were moving at that time
                    // Ex. if we are moving forward, we are just after the currently playing song -> so we need to go back as we're in a forward position
                    // Ex2. if we are moving backward, we are just before the current playing song -> so we need to go forward as we're in a backward position

                    // So in both cases we have changed the direction, so we need to set the forward flag appropriately

                    // determine the direction
                    if (!playlsit.isEmpty()) {
                        if (forward){
                            if (listIterator.hasPrevious()){
                                System.out.println("Now replaying : "+listIterator.previous().toString());
                                forward = false;
                            }else{
                                System.out.println("We are at the start of the Playlist");
                            }

                        }
                        else // if we are not going forward
                        {
                            if (listIterator.hasNext()){
                                System.out.println("Now replaying : "+listIterator.next().toString());
                                forward = true;
                            }else
                                {
                                    System.out.println("We have reached the end of Playlist");
                            }

                        }
                        break;
                    }
                    else{
                        System.out.println("No action, Playlist is empty");
                        break;
                    }
                case 4:
                    printList(playlsit);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    // probably we don't need the if check of .size()>0
                    // because it is already done at the start of the play method
                    if (playlsit.size() > 0){
                        listIterator.remove();
                        // after removing it will automatically goto the next song
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                        }
                        // but if we are at the end of the list , we will go to previous song automatically
                        else if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                        }
                        break;
                    }

                    else{
                    System.out.println("No action, Playlist is empty");
                    break;
                }

                    // As of now it is not allowing to do the delete again after doing once
                    // It is working if we delete and press forward or backward button again i.e..next or .previous if called
                    // So needs additional logic - as the above ListIterator can only be made once per call to next or previous
                    // It throws an exception - IllegalStateException if neither .next() or .previous has been called
                    // So we need to guard against that
                    // That is actually built-in to the actual linked list code itself.
                    // Exception handling (TBD) - is a way to actually trap the error
                    // we trap that using try catch block

                    // Way 1 - logic using Exception handling

                    // Way 2 - we will be calling .next() or .previous() immediately after removing a song
                    // Then we wil not get the error


                // end - switch
            }

            // end - while
        }
        // end - play method
    }

    // method : print Playlist method
    private static void printList(LinkedList<Song> playlist) {

        // using Iterator (just don't have the capability to go backwards)
        // It is perfect for looping through something once
        // Not ListIterator because we are not going forward or backward. So there is no need of it
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("====================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("============================");

    }

    // method - Print list of menus in the Music Player
    private static void printMenu(){
        System.out.println("Available Options: (Press 5 for Available options)\nPress:");
        System.out.println("0 - to quit Music Player\n" +
                "1 - forward button\n" +
                "2 - backward button\n" +
                "3 - replay button\n" +
                "4 - list of songs in the Playlist\n" +
                "5 - Music Player Options\n" +
                "6 - Delete current song from playlist");
    }

    // end - Main Class
}

// Java Software Development Kit
// other Data Structures - Trees, Queues, Hash tables, Maps and many more...