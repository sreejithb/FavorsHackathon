package com.hackathon.favors.favors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.Profile;

import java.util.ArrayList;

/**
 * Created by JiaWern on 3/9/16.
 */
public class MyProfile extends AppCompatActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);
        String methodName = getIntent().getStringExtra("Method");

        if (methodName.equals("Request")){

            final ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
            ListView lv = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> m_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
            lv.setAdapter(m_adapter);
            Button bt = (Button) findViewById(R.id.button3);
            bt.setVisibility(View.GONE);
            bt = (Button) findViewById(R.id.button5);
            bt.setVisibility(View.GONE);

            bt = (Button) findViewById(R.id.button4);

            bt.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, Request.class);
                    i.putExtra("mylist", myList);
                    i.putExtra("Method", "Request");
                    startActivity(i);
                }
            });
        }
        else if (methodName.equals("Job")){
            Bundle bundle = getIntent().getExtras();
            final String userID = bundle.getString("userID");
            final String jobID = bundle.getString("jobID");
            final ArrayList<String> myList2 = (ArrayList<String>) getIntent().getSerializableExtra("Items");
            ListView lv = (ListView) findViewById(R.id.listView2);
            ArrayAdapter<String> m_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList2);
            lv.setAdapter(m_adapter);
            Button bt = (Button) findViewById(R.id.button4);
            bt.setVisibility(View.GONE);
            bt = (Button) findViewById(R.id.button3);
            Button bt1 = (Button) findViewById(R.id.button5);

            bt.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, Request.class);
                    i.putExtra("mylist", myList2);
                    i.putExtra("userID", userID);
                    i.putExtra("jobID", jobID);
                    i.putExtra("Method", "Request");
                    startActivity(i);
                }
            });

            bt1.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, Job.class);
                    i.putExtra("mylist", myList2);
                    i.putExtra("userID", userID);
                    i.putExtra("jobID", jobID);
                    startActivity(i);
                }
            });
        }
        else {
            Bundle bundle = getIntent().getExtras();
            final String userName = bundle.getString("userID");
            TextView t = (TextView) findViewById(R.id.name);
            t.setText(userName);
            Button bt = (Button) findViewById(R.id.button4);
            bt.setVisibility(View.GONE);
            bt = (Button) findViewById(R.id.button5);
            bt.setVisibility(View.GONE);
            bt = (Button) findViewById(R.id.button3);


            bt.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, Request.class);
                    i.putExtra("Method", "New");
                    startActivity(i);
                }
            });
        }


    }

}
