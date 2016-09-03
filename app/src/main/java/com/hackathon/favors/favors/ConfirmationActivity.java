package com.hackathon.favors.favors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by davidten on 3/9/16.
 * Requires JOB ID
 */
public class ConfirmationActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_confirmation);
    }

    protected void confirmJob(View v){
        //TODO Sends confirmation to server
        //TODO redirects user to profile page
        Intent i = new Intent(getApplicationContext(),JobActivity.class);
        startActivity(i);
    }

    protected void onResume(){
        super.onResume();
        //TODO PULL DATA FROM SERVER GIVEN A JOB ID
        ArrayList<String> item_list = new ArrayList<String>(Arrays.asList("Rice", "Wholemeal bread", "Eggs", "Muffins", "a", "b", "c", "d", "e", "f", "g", "h", "i"));
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item_list);
        ListView listView = (ListView) findViewById(R.id.itemList);
        listView.setAdapter(itemsAdapter);

        TextView pName = (TextView) findViewById(R.id.deliverName);
        pName.setText("DAVID TEN");
    }
}
