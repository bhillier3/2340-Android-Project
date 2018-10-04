package edu.gatech.donationapp_77;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        logout();
        seeLocations();
    }

    private void logout() {
        Button logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Back to Login Screen
                startActivity(new Intent(HomeScreenActivity.this, SplashActivity.class));
            }
        });
    }

    private void seeLocations() {
        Button locationButton = (Button) findViewById(R.id.locButton);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to LocationListActivity
                startActivity(new Intent(HomeScreenActivity.this, LocationListActivity.class));
            }
        });
    }
}
