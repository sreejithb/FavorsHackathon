package com.hackathon.favors.myapplication.backend;

import java.util.Hashtable;
import java.util.zip.Inflater;

/**
 * Created by sreejith on 3/9/16.
 */
public class GroceryListWithRating {
    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public int getUserstat() {
        return userstat;
    }

    public void setUserstat(int userstat) {
        this.userstat = userstat;
    }

    GroceryList groceryList;
    int userstat;


    public GroceryListWithRating(GroceryList groceryList, int userstat) {
        this.groceryList = groceryList;
        this.userstat = userstat;
    }
}
