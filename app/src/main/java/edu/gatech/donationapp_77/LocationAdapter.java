package edu.gatech.donationapp_77;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocViewHolder> {

    private ArrayList<Location> locationSet;


    public static class LocViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView locTextView;
        public LocViewHolder(View v) {
            super(v);
            locTextView = (TextView) v;
        }
    }


    public LocationAdapter() {
        locationSet = Location.getLocationList();
    }

    @NonNull
    @Override
    public LocationAdapter.LocViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.loc_text_view, viewGroup, false);

        LocViewHolder vh = new LocViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(LocViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.locTextView.setText(locationSet.get(position).getName());

    }



    @Override
    public int getItemCount() {
        return locationSet.size();
    }
}
