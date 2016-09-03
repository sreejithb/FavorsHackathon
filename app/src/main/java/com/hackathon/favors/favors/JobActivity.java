package com.hackathon.favors.favors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by davidten on 3/9/16.
 *
 * This is the page that is shown to the person delivering the items.
 * This page is accessible from the summary page or the popup page.
 * Requires -> Name of requester, item name, rating, address, accepted, delivered.
 *
 */
public class JobActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_job);
    }

    protected void acceptJob(View v){
        //TODO: Send to server with Job ID, User ID.
    }

    protected void deliverItems(View v){
        //TODO: Send to server jobID
    }

    protected void onResume(){
        //POSSIBLE To get data through server calls for userID and jobID instead?
        super.onResume();
        Boolean accepted = false;
        Boolean delivered = false;

        /*
        if(getIntent().hasExtra("personName")) {
            TextView pName = (TextView) findViewById(R.id.personName);
            pName.setText(getIntent().getStringExtra("personName"));
        }
        */
        TextView pName = (TextView) findViewById(R.id.personName);
        pName.setText("DAVID TEN");
        /*
        if(getIntent().hasExtra("itemName")) {
            ArrayList<String> item_list = new ArrayList<String>();
            item_list = getIntent().getStringArrayListExtra("itemName");
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item_list);
            ListView listView = (ListView) findViewById(R.id.itemList);
            listView.setAdapter(itemsAdapter);
        }
        */
        ArrayList<String> item_list = new ArrayList<String>(Arrays.asList("Rice", "Wholemeal bread", "Eggs", "Muffins", "a", "b", "c", "d", "e", "f", "g", "h", "i"));
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item_list);
        ListView listView = (ListView) findViewById(R.id.itemList);
        listView.setAdapter(itemsAdapter);

        /*
        if(getIntent().hasExtra("rating")) {
            int intValue = getIntent().getIntExtra("rating", 0);
            //TODO Add a way to see the rating on the page. use pictures
        }
        */

        /*
        if(getIntent().hasExtra("address")) {
            TextView addr = (TextView) findViewById(R.id.personAddress);
            addr.setText(getIntent().getStringExtra("address"));
        }
        */
        TextView addr = (TextView) findViewById(R.id.personAddress);
        addr.setText("512 Menlo Street #22-01 Singapore 231413");

        /*
        if(getIntent().hasExtra("accepted")) {
             accepted = getIntent().getExtras().getBoolean("accepted");
        }
        if(getIntent().hasExtra("delivered")) {
             delivered = getIntent().getExtras().getBoolean("delivered");
        }
        */

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
