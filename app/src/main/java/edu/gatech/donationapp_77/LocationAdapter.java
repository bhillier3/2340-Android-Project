package edu.gatech.donationapp_77;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocViewHolder> {

    private ArrayList<Location> locationSet = new ArrayList<>();
    private Context context;

    public class LocViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView locTextView;
        RelativeLayout parentLayout;

        public LocViewHolder(View v) {
            super(v);
            locTextView = v.findViewById(R.id.loc_name);
            parentLayout = v.findViewById(R.id.parent_layout);
        }
    }


    public LocationAdapter(Context context) {
        locationSet = Location.getLocationList();
        this.context = context;
    }

    @NonNull
    @Override
    public LocViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_loc_view, viewGroup, false);
        LocViewHolder vh = new LocViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(LocViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.locTextView.setText(locationSet.get(position).getName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Switch to Location's view
                Intent intent = new Intent(context, LocationActivity.class);
                intent.putExtra("loc_name", locationSet.get(position).getName());
                intent.putExtra("loc_address", locationSet.get(position).getAddress());
                intent.putExtra("loc_phone", locationSet.get(position).getPhoneNumber());
                intent.putExtra("loc_lat", locationSet.get(position).getLatitude());
                intent.putExtra("loc_long", locationSet.get(position).getLongitude());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locationSet.size();
    }
}
