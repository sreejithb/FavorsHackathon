package com.hackathon.favors.favors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by KDL on 3/9/2016.
 */
public class FavorsAdapter extends ArrayAdapter<Job> {
    public FavorsAdapter(Context context, int resource, ArrayList<Job> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Job job = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.individual_jobs, parent, false);
        }
        TextView owner = (TextView)convertView.findViewById(R.id.ownerName);
        TextView noOfItems = (TextView)convertView.findViewById(R.id.noOfItems);
        TextView rep = (TextView) convertView.findViewById(R.id.rep);
        owner.setText(job.getOwner());
        noOfItems.setText(Integer.toString(job.getItems().size()));
        rep.setText("100");

        return convertView;
    }


}
