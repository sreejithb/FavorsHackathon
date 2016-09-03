package com.hackathon.favors.favors;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.hackathon.favors.myapplication.backend.myApi.MyApi;
import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;

import java.io.IOException;
import java.util.List;

/**
 * Created by sreejith on 3/9/16.
 */
public class AmINearbyService extends Service implements AsyncResponse {
    String deb = "AMI";
    static int hasfound= 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.d(deb, "started");
        runCheck();
        return 1;
    }

    private void runCheck() {
        String[] subparams = {FunctionDirectory.AMINEARBY,"Mary"};
        final CallBackEndTask callBackEndTask = new CallBackEndTask();
        callBackEndTask.setAsyncResponse(this);
        callBackEndTask.execute(new Pair<Context, String[]>(this, subparams));

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void processResult(String result) {
        Log.d(deb,result);
        if (Integer.parseInt(result) == 1){
            Intent intent = new Intent(this, MainActivity.class);
// use System.currentTimeMillis() to have a unique ID for the pending intent
            PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
            Notification n  = new Notification.Builder(this)
                    .setContentTitle("People could use your help")
                    .setSmallIcon(R.drawable.icon)
                    .setContentIntent(pIntent)
                    .setAutoCancel(true).build();
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(0, n);
        }else {
            SystemClock.sleep(1000);
            runCheck();
        }
    }


    @Override
    public void processResultList(List<GroceryListWithRating> gListResult) {
        Log.d(deb,"herer1");
    }

    @Override
    public void processResultItem(GroceryListWithRating groceryListResult) {
        Log.d(deb,"here2");
    }
}
