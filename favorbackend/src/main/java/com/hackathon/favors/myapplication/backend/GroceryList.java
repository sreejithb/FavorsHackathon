package com.hackathon.favors.myapplication.backend;

import java.util.ArrayList;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by sreejith on 3/9/16.
 */
@Entity
public class GroceryList {
    public GroceryList(){

    }
    public GroceryList(int jobid, String owner, ArrayList<String> items, int nearby, String address){
        this.jobid = jobid;
        this.owner = owner;
        this.items = items;
        this.nearby = nearby;
        this.address = address;
    }
    public GroceryList(ArrayList<String> items, int nearby, String address){
        this.items = items;
        this.nearby = nearby;
        this.address = address;
    }

    int jobid;

    public ArrayList<String> items = new ArrayList<String>();

    public String status = DeliveryStatuses.OPEN;

    public String deliverer = "";

    public String address;


    @Id
    public String owner;

    public int nearby;

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }



    public int getJobid(){
        return jobid;
    }

    public void setJobid(int jobid){
        this.jobid = jobid;
    }

    public int getNearby(){
        return this.nearby;
    }

    public void setNearby(int nearby){
        this.nearby = nearby;
    }

    public ArrayList<String> getItems(){
        return  items;
    }
    public void addItem(String item){
        items.add(item);
    }
    public void setOWner(String owner){
        this.owner =owner;
    }

    public String getOwner(){
        return this.owner;
    }

    public void setDeliverer(String deliverer){
        this.deliverer = deliverer;
    }

    public String getDeliverer(){
        return deliverer;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }




}
