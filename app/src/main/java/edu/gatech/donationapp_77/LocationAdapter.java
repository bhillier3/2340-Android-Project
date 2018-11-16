package edu.gatech.donationapp_77;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * An adapter for the location RecyclerView
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocViewHolder> {

    private final List<Location> locationSet;
    private final Context context;

    public class LocViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        final TextView locTextView;
        final RelativeLayout parentLayout;

        LocViewHolder(View v) {
            super(v);
            locTextView = v.findViewById(R.id.loc_name);
            parentLayout = v.findViewById(R.id.parent_layout);
        }
    }

    /**
     * Constructor for the adapter
     * @param context the context
     */
    public LocationAdapter(Context context) {
        locationSet = Location.getLocationList();
        this.context = context;
    }

    @NonNull
    @Override
    public LocViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.recycler_loc_view, viewGroup, false);
        return new LocViewHolder(v);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull LocViewHolder holder, final int position) {
        // - get element from your data set at this position
        // - replace the contents of the view with that element
        final Location gotten = locationSet.get(position);

        holder.locTextView.setText(gotten.getName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Switch to Location's view
                LocationManagementFacade.setLocation(gotten);
                Intent intent = new Intent(context, LocationActivity.class);
                intent.putExtra("loc_name", gotten.getName());
                intent.putExtra("loc_address", gotten.getAddress());
                intent.putExtra("loc_phone", gotten.getPhoneNumber());
                intent.putExtra("loc_lat", gotten.getLatitude());
                intent.putExtra("loc_long", gotten.getLongitude());
                LocationType locType = gotten.getType();
                intent.putExtra("loc_type", locType.getStringRep());
                //intent.putParcelableArrayListExtra("inventory", (ArrayList<Item>)
                // locationSet.get(position).getInventory());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locationSet.size();
    }
}
