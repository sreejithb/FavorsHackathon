package com.hackathon.favors.favors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;

import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by davidten on 3/9/16.
 * Requires JOB ID
 */
public class ConfirmationActivity extends AppCompatActivity implements AsyncResponse{
    String jobID;

    @Override
    public void processResult(String result) {
        //TextView textView = (TextView)findViewById(R.id.textView2);
        //textView.setText(result);
    }

    @Override
    public void processResultList(List<GroceryListWithRating> gListResult) {
        //TextView textView = (TextView)findViewById(R.id.textView2);
        //textView.setText(gListResult.toString());
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_confirmation);
    }

    protected void confirmJob(View v){
        //Sends confirmation to server
        String[] subparams = {FunctionDirectory.SENDDELIVERED, jobID};
        final CallBackEndTask callBackEndTask = new CallBackEndTask();
        callBackEndTask.setAsyncResponse(this);
        callBackEndTask.execute(new Pair<Context, String[]>(this, subparams));

        //TODO redirects user to profile page instead of JobActivity Page
        Intent i = new Intent(getApplicationContext(),JobActivity.class);
        startActivity(i);
    }

    protected void onResume(){
        super.onResume();

        //DEBUG
        jobID = "123";

        if(getIntent().hasExtra("jobID")) {
            jobID = getIntent().getStringExtra("jobID");
        }

        //TODO PULL DATA FROM SERVER GIVEN A JOB ID


        ArrayList<String> item_list = new ArrayList<String>(Arrays.asList("Rice", "Wholemeal bread", "Eggs", "Muffins", "a", "b", "c", "d", "e", "f", "g", "h", "i"));
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item_list);
        ListView listView = (ListView) findViewById(R.id.itemList);
        listView.setAdapter(itemsAdapter);

        TextView pName = (TextView) findViewById(R.id.deliverName);
        pName.setText("DAVID TEN");
    }
}
