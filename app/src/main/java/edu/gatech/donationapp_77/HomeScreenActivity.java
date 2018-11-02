package edu.gatech.donationapp_77;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView welcomeText;
    private User loggedIn;

    LocationManagementFacade lmf = LocationManagementFacade.getInstance();
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);



        welcomeText = findViewById(R.id.welcomeText);
        loggedIn = User.getLoggedInUser();
        String welcomeString = "Welcome " + loggedIn.getName() + "!\nUser type: "
                + loggedIn.getType() + ".";
        if (loggedIn.getLocation() != null) {
            welcomeString += "\nLocation: " + loggedIn.getLocation().toString();
        }
        welcomeText.setText(welcomeString);

        logout();
        seeLocations();
        newDonation();
        searchItems();
        saveData();
        loadData();
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
                Intent intent = new Intent(HomeScreenActivity.this, MakeDonationActivity.class);
                //intent.putExtra("location", loggedIn.getLocation());
                startActivity(intent);
            }
        });
    }

    private void searchItems() {
        Button searchButton = findViewById(R.id.searchItemButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, InventoryListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveData() {
        Button searchButton = findViewById(R.id.saveData);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = new File(getFilesDir(), LocationManagementFacade.DEFAULT_JSON_FILE_NAME);
                lmf.saveJson(file);
            }
        });
    }

    private void loadData() {
        Button searchButton = findViewById(R.id.loadData);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = new File(getFilesDir(), LocationManagementFacade.DEFAULT_JSON_FILE_NAME);
                lmf.loadJson(file);
            }
        });
    }
}
