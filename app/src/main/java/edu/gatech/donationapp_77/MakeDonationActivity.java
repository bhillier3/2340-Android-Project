package edu.gatech.donationapp_77;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MakeDonationActivity extends AppCompatActivity {

    private Button cancel;
    private Button submit;
    private Spinner quantitySpinner;
    private Spinner categorySpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_donation);

        cancel = (Button) findViewById(R.id.cancelButton);
        submit = (Button) findViewById(R.id.donateButton);
        quantitySpinner = (Spinner) findViewById(R.id.quantitySpinner);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

        // Set quantitySpinner drop down view
        Integer[] nums = new Integer[100];
        for (int i = 0; i < 100; i++) { nums[i] = i; }
        ArrayAdapter<Integer> adapterQty = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nums);
        adapterQty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(adapterQty);

        // Set categorySpinner drop down view
//        ArrayAdapter<CategoryType> adapterCat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CategoryType.values());
//        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        categorySpinner.setAdapter(adapterCat);

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
        // Go to item's page
//        startActivity(new Intent(this, ItemActivity.class));
    }
}
