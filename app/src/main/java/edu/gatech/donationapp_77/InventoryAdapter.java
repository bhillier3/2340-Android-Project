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

import java.util.ArrayList;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {
    private ArrayList<Item> inventory;
    private Context context;

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_inventory_view, viewGroup, false);
        InventoryViewHolder vh = new InventoryViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, final int position) {
        holder.itemName.setText(inventory.get(position).getName());
        holder.itemDesc.setText(inventory.get(position).getDescription());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InventoryListActivity.class);
                // Put extras for item view here

                // Start new activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return inventory.size();
    }

    public class InventoryViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public TextView itemDesc;
        RelativeLayout parentLayout;

        public InventoryViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.itemName);
            itemDesc = view.findViewById(R.id.itemDescription);
            parentLayout = view.findViewById(R.id.parent_layout);
        }
    }

    public InventoryAdapter(ArrayList<Item> inventory, Context context) {
        this.inventory = inventory;
        this.context = context;
    }

}
