package com.hackathon.favors.favors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.Profile;

import java.util.ArrayList;

/**
 * Created by JiaWern on 3/9/16.
 */
public class MyProfile extends AppCompatActivity implements View.OnClickListener {
    TextView userTextView;
    String currUser;
    Button submit;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);
        String methodName = getIntent().getStringExtra("Method");
        Button search = (Button) findViewById(R.id.button6);
        userTextView = (TextView) findViewById(R.id.name) ;
        SharedPreferences prefs = this.getSharedPreferences(getString(R.string.sharedprefname), Context.MODE_PRIVATE);
        //prefs.edit().putString(getString(R.string.userid), userName).apply();
        currUser = prefs.getString(getString(R.string.userid), "Sreejith");
        userTextView.setText(currUser);
        /*submit = (Button)findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.name);
        currUser = editText.getText().toString();
        editText.setText(getIntent().getExtras().getString("userID"));
*/

        if (methodName.equals("Request")){
            // NO JOB ACCEPTED YET BUT HAVE A LIST OF GROCERIES THEY WANT PEOPLE TO BUY
            final ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
            ListView lv = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> m_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
            lv.setAdapter(m_adapter);
            Button bt = (Button) findViewById(R.id.button3);
            bt.setVisibility(View.GONE);
            bt = (Button) findViewById(R.id.button5);
            bt.setVisibility(View.GONE);

            bt = (Button) findViewById(R.id.button4);

            search.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, PopupActivity.class);
                    i.putExtra("mylist", myList);
                    i.putExtra("userID",currUser);
                    i.putExtra("jobID",1);
                    startActivity(i);
                }
            });

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
            // NEW JOB ACCEPTED AND NO LIST OF GROCERIES THEY WANT TO BUY
            Bundle bundle = getIntent().getExtras();
            if(bundle ==null){
                Log.d("Bundle:","is null");
            }
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

            search.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, PopupActivity.class);
                    i.putExtra("mylist", myList2);
                    i.putExtra("jobID",1);
                    i.putExtra("userID",currUser);
                    startActivity(i);
                }
            });

            bt1.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, JobActivity.class);
                    i.putExtra("mylist", myList2);
                    i.putExtra("userID", userID);
                    i.putExtra("jobID", jobID);
                    startActivity(i);
                }
            });
        }
        else {
            // NEW PAGE (NO JOB ACCEPTED YET AND NO GROCERIES THEY WANT PEOPLE TO BUY)
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

            search.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent i = new Intent(MyProfile.this, PopupActivity.class);
                    i.putExtra("userID",currUser);
                    startActivity(i);
                }
            });
        }


    }

    @Override
    public void onClick(View view) {
       /* editText = (EditText) findViewById(R.id.name);
        currUser = editText.getText().toString();
*/
    }
}
