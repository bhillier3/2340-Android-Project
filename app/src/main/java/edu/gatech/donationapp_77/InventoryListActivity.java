package edu.gatech.donationapp_77;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class InventoryListActivity extends AppCompatActivity{

    private RecyclerView invRecyclerView;
    private InventoryAdapter adapter;
    private LinearLayoutManager invLayoutManager;
    private ArrayList<Item> inventory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_list);
        //inventory = getIntent().getParcelableArrayListExtra("inventory");
        inventory = (ArrayList<Item>) Location.getSelectedLoc().getInventory();
        initRecyclerview();
    }

    private void initRecyclerview() {
        invRecyclerView = findViewById(R.id.invRecView);
        adapter = new InventoryAdapter(inventory, this);
        invRecyclerView.setAdapter(adapter);
        invLayoutManager = new LinearLayoutManager(this);
        invRecyclerView.setLayoutManager(invLayoutManager);
    }
}
