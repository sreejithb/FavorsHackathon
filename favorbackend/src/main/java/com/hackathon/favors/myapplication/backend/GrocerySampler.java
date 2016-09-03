package com.hackathon.favors.myapplication.backend;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by sreejith on 3/9/16.
 */
public class GrocerySampler {
    ArrayList<GroceryListWithRating> groceryLists = new ArrayList<GroceryListWithRating>();
    Hashtable<String,Integer> userstats = new Hashtable<String, Integer>();

    private void populateUserStats(){
        for (GroceryListWithRating g:groceryLists){
            if(!userstats.contains(g.getGroceryList().getOwner())){
                userstats.put(g.getGroceryList().getOwner(), new Random().nextInt(5));
            }
        }
    }
    private void populateDummy(){
        GroceryList temp = new GroceryList(1,"1234",new ArrayList<String>() {{
            add("HLMilk");
            add("6 Eggs");
            add("Maggi Mee");
        }},1,"#01-145, 325 Clementi Avenue 5, 120325");
        groceryLists.add(new GroceryListWithRating(temp,userstats.get(temp.getOwner())));

        temp = new GroceryList(2,"5678",new ArrayList<String>() {{
            add("Thai Fragrant Rice");
            add("Pepsi 1.5L");
        }},0,"#22-132, 435 Lakside Avenue 1, 180435");
        groceryLists.add(new GroceryListWithRating(temp,userstats.get(temp.getOwner())));


        temp = new GroceryList(3,"abcd",new ArrayList<String>() {{
            add("Baked Beans");
            add("Soya Sauce");
            add("Longans");
        }},1,"#12-33,2 Clementi Avenue 3, Singapore 120002 ");
        groceryLists.add(new GroceryListWithRating(temp,userstats.get(temp.getOwner())));

        temp = new GroceryList(4,"efgh",new ArrayList<String>() {{
            add("Fish");
            add("Brocolli");
            add("Beer");
        }},1,"#45-33,32 Dover Crescent,Singapore - 124365");
        groceryLists.add(new GroceryListWithRating(temp,userstats.get(temp.getOwner())));

        temp = new GroceryList(5,"ijkl",new ArrayList<String>() {{
            add("Campbell soup");
            add("Ice Lemon Tea cans");
            add("Ice cream");
        }},1,"#12-23, 335 Clementi Avenue 6, Singapore- 120221");
        groceryLists.add(new GroceryListWithRating(temp,userstats.get(temp.getOwner())));

        temp = new GroceryList(6,"mnop",new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }},0,"test");
        groceryLists.add(new GroceryListWithRating(temp,userstats.get(temp.getOwner())));

        populateUserStats();

    }

    public ArrayList<GroceryListWithRating> getNearby(int nearbyid){
        ArrayList<GroceryListWithRating> nearbylists = new ArrayList<GroceryListWithRating>();
        for (GroceryListWithRating g : groceryLists){
            if ((g.getGroceryList().nearby==nearbyid) && (g.getGroceryList().status == DeliveryStatuses.OPEN)){
                nearbylists.add(g);
            }
        }
        return nearbylists;
    }

    public void populate(){
        if (!groceryLists.isEmpty()){
            populateDummy();
        }
    }

    public void addNewJob(GroceryList groceryList){
        if (!userstats.contains(groceryList.getOwner())){
            userstats.put(groceryList.getOwner(),0);
        }
        groceryLists.add(new GroceryListWithRating(groceryList,userstats.get(groceryList.getOwner())));
    }


    public void updatejob(int jobid, String delid, String status) {
        for (GroceryListWithRating g:groceryLists){
            if (g.getGroceryList().getJobid()==jobid){
                g.getGroceryList().setDeliverer(delid);
                g.getGroceryList().setStatus(status);
            }
        }
    }

    public void donejob(int jobid) {
        for (GroceryListWithRating g:groceryLists){
            if (g.getGroceryList().getJobid()==jobid){
                g.getGroceryList().setStatus(DeliveryStatuses.DELIVERED);
                int currentstat = userstats.get(g.getGroceryList().getDeliverer());
                userstats.put(g.getGroceryList().getDeliverer(),currentstat + 1);
            }
        }
    }
}
