package edu.gatech.donationapp_77;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);



        welcomeText = findViewById(R.id.welcomeText);
        User loggedIn = User.getLoggedInUser();
        String welcomeString = "Welcome " + loggedIn.getName() + "!\nUser type: "
                + loggedIn.getType() + ".";
        welcomeText.setText(welcomeString);

        logout();
        seeLocations();
        newDonation();
    }

    private void logout() {
        Button logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Back to Login Screen, removes loggedInUser
                User.setLoggedInUser(null);
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

    private void newDonation() {
        Button newDonationButton = findViewById(R.id.newDonButton);
        newDonationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreenActivity.this, MakeDonationActivity.class));
            }
        });
    }


}
