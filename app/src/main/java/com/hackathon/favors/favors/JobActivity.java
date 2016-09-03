package com.hackathon.favors.favors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by davidten on 3/9/16.
 *
 * This is the page that is shown to the person delivering the items.
 * This page is accessible from the summary page or the popup page.
 * Requires -> Name of requester, item name, rating, address, accepted, delivered.
 *
 */
public class JobActivity extends AppCompatActivity implements AsyncResponse{
    private static final String TAG = JobActivity.class.getSimpleName();
    String jobID;
    String userID;
    ArrayList<String> item_list;

    @Override
    public void processResultItem(GroceryListWithRating groceryListResult) {
        //Log.d(TAG, "HELLO WORLD");
    }

    @Override
    public void processResult(String result) {
        Log.d(TAG, result);
    }

    @Override
    public void processResultList(List<GroceryListWithRating> gListResult) {
        Log.d(TAG, gListResult.toString());
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_job);
    }

    protected void acceptJob(View v){
        String[] subparams = {FunctionDirectory.SENDACCEPTJOB, jobID, userID};
        final CallBackEndTask callBackEndTask = new CallBackEndTask();
        callBackEndTask.setAsyncResponse(this);
        callBackEndTask.execute(new Pair<Context, String[]>(this, subparams));

        //TODO: REDIRECT BACK TO PROFILE INSTEAD OF CONFIRMATION
        Intent i = new Intent(getApplicationContext(), ConfirmationActivity.class);
        i.putExtra("jobID", jobID);
        i.putExtra("Items", item_list);
        startActivity(i);

    }

    protected void deliverItems(View v){
        String[] subparams = {FunctionDirectory.SENDHANDOVER, jobID, userID};
        final CallBackEndTask callBackEndTask = new CallBackEndTask();
        callBackEndTask.setAsyncResponse(this);
        callBackEndTask.execute(new Pair<Context, String[]>(this, subparams));
    }

    protected void onResume(){
        //POSSIBLE To get data through server calls for userID and jobID instead?
        super.onResume();
        String status = "";
        Boolean accepted = false;
        Boolean delivered = false;

        if(getIntent().hasExtra("Status")) {
            status = getIntent().getStringExtra("Status");
        }

        if(status.equals("delivered")){
            accepted = true;
            delivered = true;
        } else if(status.equals("open")){
        } else if(status.equals("otw")){
            accepted = true;
            delivered = false;
        } else if(status.equals("handed over")){
            accepted= true;
            delivered = true;
        }

        if(getIntent().hasExtra("jobID")) {
            jobID = getIntent().getStringExtra("jobID");
        }
        if(getIntent().hasExtra("userID")) {
            userID = getIntent().getStringExtra("userID");
        }
        if(getIntent().hasExtra("Owner")) {
            TextView pName = (TextView) findViewById(R.id.personName);
            pName.setText(getIntent().getStringExtra("Owner"));
        }
        if(getIntent().hasExtra("Items")) {
            item_list = new ArrayList<String>();
            item_list = getIntent().getStringArrayListExtra("Items");
            //display the items
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item_list);
            ListView listView = (ListView) findViewById(R.id.itemList);
            listView.setAdapter(itemsAdapter);
        }
        if(getIntent().hasExtra("Address")) {
            TextView addr = (TextView) findViewById(R.id.personAddress);
            addr.setText(getIntent().getStringExtra("Address"));
        }

        Button deliverButton = (Button) findViewById(R.id.deliver);
        Button acceptButton = (Button) findViewById(R.id.accept);

        if(!accepted){
            //only show accept button.
            deliverButton.setVisibility(View.INVISIBLE);
        } else if(delivered){
            //don't show any buttons
            deliverButton.setVisibility(View.INVISIBLE);
            acceptButton.setVisibility(View.INVISIBLE);
        } else{
            //accepted and not delivered. show deliver button
            acceptButton.setVisibility(View.INVISIBLE);
        }
    }

}
