package edu.gatech.donationapp_77;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    private String locName;
    private String locAddress;
    private String locPhone;
    private String locLat;
    private String locLong;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        // Check for incoming intents
        if (getIntent().hasExtra("loc_name") &&
                getIntent().hasExtra("loc_address") &&
                getIntent().hasExtra("loc_phone")) {
            locName = getIntent().getStringExtra("loc_name");
            locAddress = getIntent().getStringExtra("loc_address");
            locPhone = getIntent().getStringExtra("loc_phone");
            locLat = getIntent().getStringExtra("loc_lat");
            locLong = getIntent().getStringExtra("loc_long");

            setLocData(locName, locAddress, locPhone, locLat, locLong);
        }
    }

    private void setLocData(String locName, String locAddress, String locPhone, String locLat, String locLong) {
        TextView name = findViewById(R.id.loc_name);
        TextView address = findViewById(R.id.loc_address);
        TextView phone = findViewById(R.id.loc_phone);
        TextView latitude = findViewById(R.id.loc_lat);
        TextView longitude = findViewById(R.id.loc_long);

        name.setText(locName);
        address.setText("Address: " + locAddress);
        phone.setText("Phone: " + locPhone);
        latitude.setText("Latitude: " + locLat);
        longitude.setText("Longitude: " + locLong);
    }

}
