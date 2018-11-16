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

import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {
    private final List<Item> inventory;
    private final Context context;

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_inventory_view, viewGroup, false);
        return new InventoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, final int position) {
        final Item gotten = inventory.get(position);
        holder.itemName.setText(gotten.getName());
        holder.itemDesc.setText(gotten.getDescription());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DonationDetailActivity.class);
                // Put extras for item view here
                intent.putExtra("itemName", gotten.getName());
                intent.putExtra("itemQty", gotten.getQuantity());
                intent.putExtra("itemValue", gotten.getValue());
                intent.putExtra("itemDesc", gotten.getDescription());
                intent.putExtra("itemComments", gotten.getComments());
                intent.putExtra("itemCategory", gotten.getCategory().toString());
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
        final TextView itemName;
        final TextView itemDesc;
        final RelativeLayout parentLayout;

        InventoryViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.itemName);
            itemDesc = view.findViewById(R.id.itemDescription);
            parentLayout = view.findViewById(R.id.parent_layout);
        }
    }

    public InventoryAdapter(List<Item> inventory, Context context) {
        this.inventory = inventory;
        this.context = context;
    }

}
