package com.navjeet;

import java.util.ArrayList;

public class GroceryList {

    // Analogous Array
   // private int[] myNumbers = new int[10];


    private ArrayList<String> groceryList = new ArrayList<String>();

    // generating getter
    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    // addition
    public void addGroceryItem(String item) {

        groceryList.add(item);

    }

    // print the elements of ArrayList
    // finding size of the ArrayList
    // this printing should also go to the Main class
    // so consequently you wouldn't have to worry about +1
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items" +
                " in your grocery list");

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + "." + groceryList.get(i));
        }

    }

    // modifying / replacing / updating an item
    // another thing to note is that:
    // we didn't have to use positions
    // we might want to do in an ideal scenario - because we don't want to force the user to specify position
    // we can search/find the item and then delete it

    // making this method private to be only accessible to GrocerList Class
    private void modifyGroceryItem(int position, String item) {

        groceryList.set(position, item);
        System.out.println("Grocery item " + (position + 1) + " has been modified" +
                " with " + item);

    }

    // overloading modifyGroceryItem for code refactoring
    public void modifyGroceryItem(String newItem){

        // we need a method that returns the integer / position to modify
        // we will refactor existing findItem method to return the integer needed


        int position = findItem(newItem);
        if (position >= 0){
            modifyGroceryItem(position,newItem);
        }

    }

    public void modifyGroceryItem(String oldItem, String newItem){

        // check if the current item exists
        int position = findItem(oldItem);
        System.out.println(position);
        if (position >= 0){
            modifyGroceryItem(position,newItem);
        }

    }


    // removing item from List
    private void removeGroceryItem(int position) {

        // we could have done her: position - 1
        // like we have done position + 1 in above method
        // generally wouldn't want to do that, because it is better practice in this case to update the Main class

       // can remove the below method now after the refactoring we did
       // String item = groceryList.get(position);
        groceryList.remove(position);

    }

    // overloading removeGroceryItem method
    public void removeGroceryItem(String item){

        int position = findItem(item);
        if (position >= 0){
            removeGroceryItem(position);
        }

    }


    // finding an item
    // querying our ArrayList
   /* public String findItem(String searchItem) {


        // to figure out if an item is present int the List
        boolean exists = groceryList.contains(searchItem);
        System.out.println("Item exists is - " + exists);

        // to get the lowest index of the item, if found
        int position = groceryList.indexOf(searchItem);

        // if item found, let us return the searchItem back
        // otherwise return null

        if (position >= 0) {
            return groceryList.get(position);
        }

        return null;
    }*/


   // we don't want to expose the integer to the calling programm

    private int findItem(String searchItem){

        return groceryList.indexOf(searchItem);
    }

    // we need to create another method to enable to accept grocery item name
    // And returns true false accordingly

    public boolean onFile(String searchItem){

        int position = findItem(searchItem);
        if (position >= 0){
            return true;
        }

        return false;
    }


}
