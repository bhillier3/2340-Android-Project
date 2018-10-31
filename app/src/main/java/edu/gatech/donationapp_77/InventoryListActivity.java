package edu.gatech.donationapp_77;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class InventoryListActivity extends AppCompatActivity{

    private RecyclerView invRecyclerView;
    private InventoryAdapter adapter;
    private LinearLayoutManager invLayoutManager;
    private ArrayList<Item> inventory;
    private Location currentLocation;
    private Category currentCategory;
    private Spinner locationSpinner;
    private Spinner categorySpinner;
    private Button updateButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_list);
        //inventory = getIntent().getParcelableArrayListExtra("inventory");



        locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        updateButton = findViewById(R.id.updateResultsButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResults();
            }
        });

        ArrayAdapter<Location> locAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Location.getLocationList());
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locAdapter);

        ArrayAdapter<Category> catAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Category.values());
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(catAdapter);

        updateResults();
    }

    private void updateResults() {
        currentLocation = (Location) locationSpinner.getSelectedItem();
        currentCategory = (Category) categorySpinner.getSelectedItem();
        ArrayList<Item> tempInventory = (ArrayList<Item>) currentLocation.getInventory();
        inventory = new ArrayList<Item>();

        for (Item item : tempInventory) {
            if (item.getCategory().equals(currentCategory)) {
                inventory.add(item);
            }
        }

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
