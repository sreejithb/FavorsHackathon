package com.hackathon.favors.favors;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.hackathon.favors.myapplication.backend.myApi.MyApi;
import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AsyncResponse {
    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);
        Intent i= new Intent(this, AmINearbyService.class);
// potentially add data to the intent
        this.startService(i);

        info = (TextView) findViewById(R.id.info);
        loginButton = (LoginButton) findViewById(R.id.login_button);

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    String userName = "David";
                    @Override
                    public void onSuccess(LoginResult loginResult) {
//                        GraphRequest request = GraphRequest.newMeRequest(
//                                loginResult.getAccessToken(),
//                                new GraphRequest.GraphJSONObjectCallback() {
//                                    @Override
//                                    public void onCompleted(JSONObject object, GraphResponse response) {
//                                        Log.v("LoginActivity", response.toString());
//
//                                        // Application code
//                                        try {
//                                            System.out.println("Here");
//                                            userName = object.getString("name");
//                                        }
//                                        catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//
//                                    }
//                                });
                        Intent i = new Intent(MainActivity.this, MyProfile.class);
//                        String userName = loginResult.getAccessToken().getUserId();

                        Bundle bundle = new Bundle();
                        bundle.putString("userID", userName);
                        i.putExtras(bundle);
                        i.putExtra("Method", "Main");
                        startActivity(i);

                    }

                    @Override
                    public void onCancel() {
                        info.setText("Login attempt canceled.");
                    }

                    @Override
                    public void onError(FacebookException e) {
                        info.setText("Login attempt failed.");
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
    public void processResultItem(GroceryListWithRating groceryListResult) {

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
