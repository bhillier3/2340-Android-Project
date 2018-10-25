package edu.gatech.donationapp_77;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class InventoryListActivity extends Activity {

    private RecyclerView invRecyclerView;
    private InventoryAdapter adapter;
    private LinearLayoutManager invLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_list);
        ArrayList<Item> inventory = getIntent().getParcelableArrayListExtra("list");
        initRecyclerview(inventory);
    }

    private void initRecyclerview(ArrayList<Item> inventory) {
        invRecyclerView = findViewById(R.id.invRecView);
        adapter = new InventoryAdapter(inventory, this);
    }
}
