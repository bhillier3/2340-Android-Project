package edu.gatech.donationapp_77;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

/**
 * The activity that the user will use to get to other activities in the app
 */
public class HomeScreenActivity extends AppCompatActivity {

    private LocationManagementFacade lmf = LocationManagementFacade.getInstance();
    private UserManagementFacade umf = UserManagementFacade.getInstance();
    private File file;
    private File user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        TextView welcomeText = findViewById(R.id.welcomeText);
        User loggedIn = User.getLoggedInUser();
        String welcomeString = "Welcome " + loggedIn.getName() + "!\nUser type: "
                + loggedIn.getType() + ".";
        if (loggedIn.getLocation() != null) {
            welcomeString += "\nLocation: " + loggedIn.getLocation().toString();
        }
        welcomeText.setText(welcomeString);

        if (User.getLoggedInUser().getType() == UserType.ADMIN) {
            Button lockUnlockButton = findViewById(R.id.lockUnlockButton);
            lockUnlockButton.setVisibility(View.VISIBLE);
            lockUnlock();
        }

        logout();
        seeLocations();
        newDonation();
        searchItems();
        saveData();
        loadData();
        viewMap();
    }

    private void lockUnlock() {
        Button lockUnlockButton = findViewById(R.id.lockUnlockButton);
        lockUnlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void logout() {
        Button logoutButton = findViewById(R.id.logoutButton);
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
        Button locationButton = findViewById(R.id.locButton);
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
                user = new File(getFilesDir(), UserManagementFacade.DEFAULT_JSON_FILE_NAME);
                umf.saveJson(user);
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
                user = new File(getFilesDir(), UserManagementFacade.DEFAULT_JSON_FILE_NAME);
                umf.loadJson(user);
            }
        });
    }

    private void viewMap() {
        Button mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
