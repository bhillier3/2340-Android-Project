package edu.gatech.donationapp_77;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    private String locName;
    private String locAddress;
    private String locPhone;

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

            setLocData(locName, locAddress, locPhone);
        }
    }

    private void setLocData(String locName, String locAddress, String locPhone) {
        TextView name = findViewById(R.id.loc_name);
        TextView address = findViewById(R.id.loc_address);
        TextView phone = findViewById(R.id.loc_phone);

        name.setText(locName);
        address.setText(locAddress);
        phone.setText(locPhone);
    }

}
