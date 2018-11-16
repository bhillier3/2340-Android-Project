package edu.gatech.donationapp_77;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity to display the details of a location
 */
public class LocationActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        getIncomingIntent();

        Button inventoryButton = findViewById(R.id.inventoryButton);
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewInventory();
            }
        });
    }

    private void getIncomingIntent() {
        // Check for incoming intents
        Intent gotten = getIntent();
        if (gotten.hasExtra("loc_name") &&
                gotten.hasExtra("loc_address") &&
                gotten.hasExtra("loc_phone")) {
            String locName = gotten.getStringExtra("loc_name");
            String locAddress = gotten.getStringExtra("loc_address");
            String locPhone = gotten.getStringExtra("loc_phone");
            String locLat = gotten.getStringExtra("loc_lat");
            String locLong = gotten.getStringExtra("loc_long");
            String locType = gotten.getStringExtra("loc_type");
            //noinspection unchecked
            //List<Item> inventory = (ArrayList<Item>) Location.getSelectedLoc().getInventory();
            //inventory = getIntent().getParcelableArrayListExtra("inventory");

            setLocData(locName, locAddress, locPhone, locLat, locLong, locType);
        }
    }

    @SuppressWarnings("MethodWithTooManyParameters")
    private void setLocData(CharSequence locName, String locAddress, String locPhone,
                            String locLat, String locLong, String locType) {
        TextView name = findViewById(R.id.loc_name);
        TextView address = findViewById(R.id.loc_address);
        TextView phone = findViewById(R.id.loc_phone);
        TextView latitude = findViewById(R.id.loc_lat);
        TextView longitude = findViewById(R.id.loc_long);
        TextView locationType = findViewById(R.id.loc_type);

        name.setText(locName);
        String StringLocAddress = "Address: " + locAddress;
        address.setText(StringLocAddress);
        String stringLocPhone = "Phone: " + locPhone;
        phone.setText(stringLocPhone);
        String stringLocLat = "Latitude: " + locLat;
        latitude.setText(stringLocLat);
        String stringLocLong = ("Longitude: " + locLong);
        longitude.setText(stringLocLong);
        String stringLocType = "Location Type: " + locType;
        locationType.setText(stringLocType);
    }

    private void viewInventory() {
        Intent intent = new Intent(LocationActivity.this, InventoryListActivity.class);
        //intent.putParcelableArrayListExtra("inventory", inventory);
        startActivity(intent);
    }

}
