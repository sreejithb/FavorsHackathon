package com.hackathon.favors.favors;

import java.util.ArrayList;

/**
 * Created by KDL on 3/9/2016.
 */
public class Job {
    final String owner;
    final String status;
    final String address;
    final ArrayList<String> items;
    String deliverer;
    final int nearby;
    final int rep;



    final int jobid;

    public Job(String owner, int jobid, String status, String address, ArrayList<String> items, int nearby, int rep){
        this.owner = owner;
        this.jobid = jobid;
        this.status = status;
        this.address = address;
        this.items = items;
        this.nearby = nearby;
        this.rep = rep;
    }

    public String getOwner() {
        return owner;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public int getRep(){
        return rep;
    }
    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public int getNearby() {
        return nearby;
    }

    public int getJobid() {
        return jobid;
    }
}
