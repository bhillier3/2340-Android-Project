package edu.gatech.donationapp_77;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InventoryListActivity extends AppCompatActivity{

    private RecyclerView invRecyclerView;
    private ArrayList<Item> inventory;
    private Spinner locationSpinner;
    private Spinner categorySpinner;
    private CheckBox categoryCheck;
    private CheckBox allLocations;
    private EditText nameSearch;
    private TextView noResults;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_list);
        //inventory = getIntent().getParcelableArrayListExtra("inventory");



        locationSpinner = findViewById(R.id.locationSpinner);
        categorySpinner = findViewById(R.id.categorySpinner);
        categorySpinner.setEnabled(false);
        nameSearch = findViewById(R.id.itemSearch);
        noResults = findViewById(R.id.noResults);
        noResults.setVisibility(View.INVISIBLE);

        Button updateButton = findViewById(R.id.updateResultsButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResults();
            }
        });

        createCheckBoxes();

        ArrayAdapter<Location> locAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Location.getLocationList());
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locAdapter);

        ArrayAdapter<Category> catAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Category.values());
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(catAdapter);

        initRecyclerview();

        updateResults();
    }

    private void updateResults() {
        Location currentLocation = (Location) locationSpinner.getSelectedItem();
        Category currentCategory = (Category) categorySpinner.getSelectedItem();

        Collection<Item> tempInventory = new ArrayList<>();

        if (allLocations.isChecked()) {
            tempInventory = new ArrayList<>();
            for (Location loc : Location.getLocationList()) {
                tempInventory.addAll(loc.getInventory());
            }
        } else {
            tempInventory = currentLocation.getInventory();
        }


        inventory = new ArrayList<>();

        for (Item item : tempInventory) {
            if (categoryCheck.isChecked() && item.getCategory().equals(currentCategory)) {
                Log.e("Testing", "category search");
                inventory.add(item);
            } else if (!categoryCheck.isChecked()
                    && item.getName().contains(nameSearch.getText().toString())) {
                Log.e("Testing", "name search");
                inventory.add(item);
            }
        }

        if (inventory.isEmpty()) {
            noResults.setVisibility(View.VISIBLE);
            invRecyclerView.setVisibility(View.INVISIBLE);
        } else {
            noResults.setVisibility(View.INVISIBLE);
            invRecyclerView.setVisibility(View.VISIBLE);
        }

        initRecyclerview();
    }

    private void initRecyclerview() {
        invRecyclerView = findViewById(R.id.invRecView);
        InventoryAdapter adapter = new InventoryAdapter(inventory, this);
        invRecyclerView.setAdapter(adapter);
        LinearLayoutManager invLayoutManager = new LinearLayoutManager(this);
        invRecyclerView.setLayoutManager(invLayoutManager);
    }

    private void locCheckBoxChecked() {
        if (allLocations.isChecked()) {
            // we want to search by all locations
            locationSpinner.setEnabled(false);
        } else {
            // search just one location
            locationSpinner.setEnabled(true);

        }
    }

    private void catCheckBoxChecked() {
        if (categoryCheck.isChecked()) {
            categorySpinner.setEnabled(true);
            nameSearch.setFocusable(false);
            nameSearch.setEnabled(false);
        } else {
            categorySpinner.setEnabled(false);
            nameSearch.setFocusableInTouchMode(true);
            nameSearch.setEnabled(true);
        }
    }

    private void createCheckBoxes() {
        allLocations = findViewById(R.id.allLocCheckBox);
        allLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locCheckBoxChecked();
            }
        });
        locCheckBoxChecked();
        categoryCheck = findViewById(R.id.catCheckBox);
        categoryCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catCheckBoxChecked();
            }
        });
        catCheckBoxChecked();
    }
}
