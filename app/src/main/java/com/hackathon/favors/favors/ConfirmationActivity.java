package com.hackathon.favors.favors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    String userID;
    private static final String TAG = ConfirmationActivity.class.getSimpleName();

    @Override
    public void processResultItem(GroceryListWithRating groceryListResult) {

    }

    @Override
    public void processResult(String result) {
        Log.d(TAG, "THIS IS THE RESULT");
    }

    @Override
    public void processResultList(List<GroceryListWithRating> gListResult) {
        Log.d(TAG, "THIS IS THE LIST");
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

        Intent i = new Intent(getApplicationContext(), MyProfile.class);
        i.putExtra("userID", userID);

        startActivity(i);
    }

    protected void onResume(){
        Log.d(TAG, "ON RESUME RUNNING");
        super.onResume();

        if(getIntent().hasExtra("jobID")) {
            jobID = getIntent().getStringExtra("jobID");
        }

        if(getIntent().hasExtra("userID")) {
            userID = getIntent().getStringExtra("userID");
        }

        TextView pName = (TextView) findViewById(R.id.deliverName);
        pName.setText("Confirm that you have received your items!");
    }
}
