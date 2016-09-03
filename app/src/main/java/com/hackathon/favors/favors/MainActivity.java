package com.hackathon.favors.favors;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void processResult(String result) {
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(result);
    }

    @Override
    public void processResultList(List<GroceryListWithRating> gListResult) {
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(gListResult.toString());
    }

    @Override
    public void onClick(View v) {
        //String[] subparams = {FunctionDirectory.SENDLIST,"Ken","325 Clementi Ave 5","1"};
        String[] subparams = {FunctionDirectory.SENDNEARBY,"Mary","1"};
        final CallBackEndTask callBackEndTask = new CallBackEndTask();
        callBackEndTask.setAsyncResponse(this);
        callBackEndTask.execute(new Pair<Context, String[]>(this, subparams));
    }
}
