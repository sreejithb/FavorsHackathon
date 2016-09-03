/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.hackathon.favors.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v2",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.favors.hackathon.com",
    ownerName = "backend.myapplication.favors.hackathon.com",
    packagePath=""
  )
)
public class MyEndpoint {

    GrocerySampler grocerySampler = new GrocerySampler();
    int jobid = 10;
    int youAreNearby = 0;
    /** A simple endpoint method that takes a name and says Hi back */

    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        //grocerySampler = new GrocerySampler();
        MyBean response = new MyBean();
        response.setData("Hi, " + name);
        return response;
    }


    @ApiMethod(name = "postGroceryList")
    public MyBean postGroceryList(@Named("ownerid") String ownerid,GroceryList groceryList) {
        grocerySampler.populate();
        groceryList.setJobid(jobid++);
        groceryList.setOWner(ownerid);
        grocerySampler.addNewJob(groceryList);
        MyBean response = new MyBean();
        response.setData("Hi, " + groceryList.getOwner());
        return response;
    }

    @ApiMethod(name = "postNearby")
    public ArrayList<GroceryListWithRating> postNearby(@Named("fbid") String fbid, @Named("nearby")int nearby) {
        //GrocerySampler grocerySampler2 = new GrocerySampler();
        //grocerySampler2.populate();
        grocerySampler.populate();
        ArrayList<GroceryListWithRating> nearbylist = grocerySampler.getNearby(nearby);
        //ArrayList<GroceryListWithRating> nearbylist = grocerySampler2.getGroceryLists();
        MyBean response = new MyBean();
        response.setData("Hi, " + nearbylist.size());
        //return response;
        return nearbylist;
    }

    @ApiMethod(name = "postAcceptJob")
    public GroceryListWithRating postAccept(@Named("jobid") int jobid,@Named("delid")String delid) {
        grocerySampler.updatejob(jobid,delid, DeliveryStatuses.ONTHEWAY);
        return grocerySampler.getJob(jobid);
    }

    @ApiMethod(name = "postHandedOver")
    public GroceryListWithRating postHandedOver(@Named("jobid") int jobid,@Named("delid")String delid) {
        grocerySampler.updatejob(jobid,delid, DeliveryStatuses.HANDEDOVER);
        return grocerySampler.getJob(jobid);
    }

    @ApiMethod(name = "postDelivered")
    public GroceryListWithRating postDelivered(@Named("jobid") int jobid) {
        grocerySampler.donejob(jobid);
        return grocerySampler.getJob(jobid);
    }

    @ApiMethod(name="getUserStat")
    public MyBean getUserStat(@Named("fbid") String fbid){
        int userstat = grocerySampler.getUserStat(fbid);
        MyBean myBean = new MyBean();
        myBean.setData("UserStat: " + Integer.toString(userstat));
        return myBean;
    }

    @ApiMethod(name = "amINearby")
    public MyBean amINearby(@Named("fbid")String fbid){
        MyBean myBean = new MyBean();
        myBean.setData(Integer.toString(youAreNearby));
        return myBean;
    }
    @ApiMethod(name = "getjobInfo")
    public GroceryListWithRating getJobInfo(@Named("jobid")int jobid){
        GroceryListWithRating g = grocerySampler.getJob(jobid);
        return g;
    }


    @ApiMethod(name = "youAreNearby")
    public MyBean youAreNearby(@Named("nearbystat")int nearbystat){
        youAreNearby = nearbystat;
        MyBean myBean = new MyBean();
        myBean.setData(Integer.toString(youAreNearby));
        return myBean;
    }













}
