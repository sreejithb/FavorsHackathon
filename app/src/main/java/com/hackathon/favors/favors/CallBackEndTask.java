package com.hackathon.favors.favors;

import android.content.Context;
import android.os.AsyncTask;
import android.telecom.Call;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.hackathon.favors.myapplication.backend.myApi.MyApi;
import com.hackathon.favors.myapplication.backend.myApi.model.GroceryList;
import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;
import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRatingCollection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hackathon.favors.favors.FunctionDirectory.SENDLIST;

/**
 * Created by sreejith on 3/9/16.
 */
class CallBackEndTask extends AsyncTask<Pair<Context, String[]>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private String functionname;
    private List<GroceryListWithRating> gListResult;
    ArrayList<GroceryListWithRating> items;
    private GroceryListWithRating groceryListResult;
    String deb = "AMI";
    public AsyncResponse getAsyncResponse() {
        return asyncResponse;
    }

    public void setAsyncResponse(AsyncResponse asyncResponse) {
        this.asyncResponse = asyncResponse;
    }

    public AsyncResponse asyncResponse = null;


    @Override
    protected String doInBackground(Pair<Context, String[]>... params) {
        Log.d(deb,"Inside doinbg");
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://favorsbackend.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }
        context = params[0].first;
        String []subparams = params[0].second;
        String fname = subparams[0];
        functionname = fname;
        try{
            switch (fname){
                case FunctionDirectory.SENDLIST:
                    String ownerid = subparams[1];
                    String address = subparams[2];
                    int nearby = Integer.parseInt(subparams[3]);
                    ArrayList<String> items = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(subparams,4,subparams.length)));
                    GroceryList groceryList = new GroceryList();
                    groceryList.setOwner(ownerid);
                    groceryList.setItems(items);
                    groceryList.setAddress(address);
                    groceryList.setNearby(nearby);
                    return myApiService.postGroceryList(ownerid,groceryList).execute().getData();
                case FunctionDirectory.SENDNEARBY:
                    String delivererid = subparams[1];
                    nearby = Integer.parseInt(subparams[2]);
                    GroceryListWithRatingCollection res2 = myApiService.postNearby(delivererid, nearby).execute();
                    gListResult = res2.getItems();
                    return res2.toPrettyString();
                case FunctionDirectory.SENDACCEPTJOB:
                    int jobid = Integer.parseInt(subparams[1]);
                    delivererid = subparams[2];
                    Log.d("SEND:", delivererid);
                    Log.d("SEND:", ""+jobid);
                    return myApiService.postAcceptJob(jobid, delivererid).execute().toPrettyString();
                case FunctionDirectory.SENDHANDOVER:
                    jobid = Integer.parseInt(subparams[1]);
                    delivererid = subparams[2];
                    return myApiService.postHandedOver(jobid,delivererid).execute().toPrettyString();
                case FunctionDirectory.SENDDELIVERED:
                    jobid = Integer.parseInt(subparams[1]);
                    return myApiService.postDelivered(jobid).execute().toPrettyString();
                case FunctionDirectory.GETUSERSTAT:
                    delivererid = subparams[1];
                    return myApiService.getUserStat(delivererid).execute().getData();
                case FunctionDirectory.AMINEARBY:
                    delivererid = subparams[1];
                    return myApiService.amINearby(delivererid).execute().getData();
                case FunctionDirectory.GETJOBINFO:
                    jobid = Integer.parseInt(subparams[1]);
                    groceryListResult = myApiService.getjobInfo(jobid).execute();
                    return groceryListResult.toPrettyString();
                default:
                    return "nothing";
            }
        }catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (functionname == FunctionDirectory.SENDNEARBY){
            asyncResponse.processResultList(gListResult);
        }else if(functionname == FunctionDirectory.GETJOBINFO) {
            asyncResponse.processResultItem(groceryListResult);
        }
        else{
            asyncResponse.processResult(result);
        }


        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
