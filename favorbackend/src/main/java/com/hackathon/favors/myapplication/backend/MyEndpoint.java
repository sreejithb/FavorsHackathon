/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.hackathon.favors.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

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
    /** A simple endpoint method that takes a name and says Hi back */

    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);
        return response;
    }


    @ApiMethod(name = "postGroceryList")
    public MyBean postList(@Named("fbid") String fbid,GroceryList groceryList) {
        grocerySampler.populate();
        grocerySampler.addNewJob(groceryList);
        MyBean response = new MyBean();
        response.setData("Hi, " + groceryList.getItems());
        return response;
    }

    @ApiMethod(name = "postNearby")
    public ArrayList<GroceryListWithRating> postNearby(@Named("fbid") String fbid,@Named("nearby")int nearby) {
        grocerySampler.populate();
        ArrayList<GroceryListWithRating> nearbylist = grocerySampler.getNearby(nearby);
        return nearbylist;
    }

    @ApiMethod(name = "postAcceptJob")
    public MyBean postAccept(@Named("jobid") int jobid,@Named("delid")String delid) {
        grocerySampler.updatejob(jobid,delid, DeliveryStatuses.ONTHEWAY);
        MyBean response = new MyBean();
        response.setData("Hi");
        return response;
    }

    @ApiMethod(name = "postHandedOver")
    public MyBean postHandedOver(@Named("jobid") int jobid,@Named("delid")String delid) {
        grocerySampler.updatejob(jobid,delid, DeliveryStatuses.HANDEDOVER);
        MyBean response = new MyBean();
        response.setData("Hi");
        return response;
    }

    @ApiMethod(name = "postDelivered")
    public MyBean postDelivered(@Named("jobid") int jobid) {
        grocerySampler.donejob(jobid);
        MyBean response = new MyBean();
        response.setData("Hi");
        return response;
    }













}
