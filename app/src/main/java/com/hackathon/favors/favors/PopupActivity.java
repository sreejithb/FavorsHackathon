package com.hackathon.favors.favors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hackathon.favors.myapplication.backend.myApi.model.GroceryList;
import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sreejith on 3/9/16.
 */
public class PopupActivity  extends AppCompatActivity implements AsyncResponse, AdapterView.OnItemClickListener{
    FavorsAdapter adapter;
    ArrayList<Job> listOfJobs;
    ListView listView;
    //int userID;
    String userID;// = "Kenneth";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        //userID = getIntent().getExtras().getString("userID");
        //Log.d("UID:",userID);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //this.userID = getIntent().getStringExtra("userID");
        listView = (ListView) findViewById(R.id.listView);
        listOfJobs = new ArrayList<>();

        String[] subparams = {FunctionDirectory.SENDNEARBY,"Mary","1"};
        final CallBackEndTask callBackEndTask = new CallBackEndTask();
        callBackEndTask.setAsyncResponse(this);
        callBackEndTask.execute(new Pair<Context, String[]>(this, subparams));


    }

    @Override
    public void processResult(String result) {

    }

    @Override
    public void processResultList(List<GroceryListWithRating> gListResult) {
        Log.d("PopupActivity:" , gListResult.toString());
        for(GroceryListWithRating e: gListResult){
            GroceryList groceryList = e.getGroceryList();
            Log.d("PopupActivity ee:" , e.toString());
            Log.d("PopupActivity gList:" , groceryList.toString());
            Job job = new Job(groceryList.getOwner(),groceryList.getJobid(), groceryList.getStatus(),groceryList.getAddress(), new ArrayList<String>(groceryList.getItems()), groceryList.getNearby(), e.getUserstat());
            listOfJobs.add(job);

        }

        adapter = new FavorsAdapter(this, 3,listOfJobs);
        listView.setAdapter(adapter);
        Log.d("UID:","here");
        listView.setOnItemClickListener(this);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Call for the next Job page
                Log.d(""+ position,"Opening Job1");
                Intent intent = new Intent(getApplicationContext(), JobActivity.class);
                Job job = adapter.getItem(position);
                intent.putExtra("Owner",job.getOwner());
                intent.putExtra("jobID", job.getJobid());
                Log.d("UID:","here2");
                //String uid = getIntent().getStringExtra("userID");
                Log.d("UID:",userID);
                intent.putExtra("userID", userID);
                intent.putExtra("Address", job.getAddress());
                intent.putExtra("Status", job.getStatus());
                intent.putExtra("Items", job.getItems());
                intent.putExtra("Nearby", job.getNearby());
                intent.putExtra("Rep", job.getRep());
                startActivity(intent);
            }
        });
        */
    }

    @Override
    public void processResultItem(GroceryListWithRating groceryListResult) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Log.d(""+ position,"Opening Job1");
        Intent intent = new Intent(getApplicationContext(), JobActivity.class);
        Job job = adapter.getItem(i);
        intent.putExtra("Owner",job.getOwner());
        intent.putExtra("jobID", job.getJobid());
        Log.d("UID:","here2");
        if(getIntent().getExtras()==null){
            Log.d("UID", getIntent().toString());
            Log.d("UID","Bundle is null");
        }
        String uid = getIntent().getExtras().getString("userID");
        if (userID == null){
            Log.d("UID:","is null");
        }
        //Log.d("UID:",userID);
        intent.putExtra("userID", uid);
        intent.putExtra("Address", job.getAddress());
        intent.putExtra("Status", job.getStatus());
        intent.putExtra("Items", job.getItems());
        intent.putExtra("Nearby", job.getNearby());
        intent.putExtra("Rep", job.getRep());
        startActivity(intent);
    }
}
