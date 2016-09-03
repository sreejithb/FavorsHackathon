package com.hackathon.favors.favors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JiaWern on 3/9/16.
 */
public class Request extends AppCompatActivity{
    ArrayAdapter<String> m_adapter;
    ArrayList<String> m_listItems = new ArrayList<String>();
    /** Called when the activity is first created. */

    Button bt;
    Button submit;
    EditText et;
    TextView tv;
    ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request);
        m_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, m_listItems);
        bt = (Button) findViewById(R.id.button);
        submit = (Button) findViewById(R.id.button2);
        et = (EditText) findViewById(R.id.addedItem);
        tv = (TextView) findViewById(R.id.textView);
        lv = (ListView) findViewById(R.id.listItem);

        String methodName = getIntent().getStringExtra("Method");

        if (methodName.equals("Request")) {
            m_listItems = (ArrayList<String>) getIntent().getSerializableExtra("mylist");
            m_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, m_listItems);
        }
        Bundle bundle = getIntent().getExtras();
        final String userID = bundle.getString("userID");
        final String jobID = bundle.getString("jobID");
        lv.setAdapter(m_adapter);

        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String input = et.getText().toString();
                if(null!=input&&input.length()>0){

                    m_listItems.add(input);

                    m_adapter.notifyDataSetChanged();
                    et.setText("");

                }
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(Request.this, MyProfile.class);
                i.putExtra("mylist", m_listItems);
                i.putExtra("Method", "Request");
                startActivity(i);
            }
        });
    }

}

