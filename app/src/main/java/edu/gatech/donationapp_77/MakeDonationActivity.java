package edu.gatech.donationapp_77;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MakeDonationActivity extends AppCompatActivity {

    private Spinner quantitySpinner;
    private Spinner categorySpinner;
    private EditText name;
    private EditText value;
    private EditText description;
    private EditText comments;
    private Spinner locSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_donation);

        // grab the View's elements
        Button cancel = findViewById(R.id.cancelButton);
        Button submit = findViewById(R.id.donateButton);
        quantitySpinner = findViewById(R.id.quantitySpinner);
        categorySpinner = findViewById(R.id.categorySpinner);
        name = findViewById(R.id.itemName);
        value = findViewById(R.id.valueInput);
        description = findViewById(R.id.description);
        comments = findViewById(R.id.comments);
        locSpinner = findViewById(R.id.locSpinner);

        // Set quantitySpinner drop down view
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 100; i++) { nums.add(i); }
        ArrayAdapter<Integer> adapterQty = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nums);
        adapterQty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(adapterQty);

        // Set categorySpinner drop down view
        ArrayAdapter<Category> adapterCat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Category.values());
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapterCat);

        // Set locSpinner
        ArrayAdapter<Location> adapterLoc = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                Location.getLocationList());
        adapterLoc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locSpinner.setAdapter(adapterLoc);

        // Set Button onClick Listeners
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeDonation();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void makeDonation() {
        // Create new Item object
        String name = this.name.getText().toString();
        double value = Double.valueOf(this.value.getText().toString());
        String desc = description.getText().toString();
        String comments = this.comments.getText().toString();
        int quantity = (Integer) quantitySpinner.getSelectedItem();
        Category category = (Category) categorySpinner.getSelectedItem();
        Item item = new Item(name, value, quantity, desc, comments, category);

        // Add item to location's inventory
        if (getIntent().hasExtra("location")) {
            Location location = getIntent().getParcelableExtra("location");
            location.getInventory().add(item);
        } else {
            Location foundLoc = (Location) locSpinner.getSelectedItem();
            foundLoc.getInventory().add(item);
        }

        // Return to home page
        finish();
    }

}
