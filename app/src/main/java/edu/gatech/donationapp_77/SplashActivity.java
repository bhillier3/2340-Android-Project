package edu.gatech.donationapp_77;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.donationapp_77.LocationManagementFacade;

import java.io.File;

/**
 * The first activity the user encounters. They can login or register
 */
public class SplashActivity extends AppCompatActivity {

    private final LocationManagementFacade lmf = LocationManagementFacade.getInstance();
    private final UserManagementFacade umf = UserManagementFacade.getInstance();
    private File file;
    private File user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);
        Button saveJson = findViewById(R.id.saveJson);
        Button loadJson = findViewById(R.id.loadJson);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, LoginActivity2.class));
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
            }
        });

        saveJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                file = new File(getFilesDir(), LocationManagementFacade.DEFAULT_JSON_FILE_NAME);
                lmf.saveJson(file);
                user = new File(getFilesDir(), UserManagementFacade.DEFAULT_JSON_FILE_NAME);
                umf.saveJson(user);
            }
        });

        loadJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                file = new File(getFilesDir(), LocationManagementFacade.DEFAULT_JSON_FILE_NAME);
                lmf.loadJson(file);
                user = new File(getFilesDir(), UserManagementFacade.DEFAULT_JSON_FILE_NAME);
                umf.loadJson(user);
            }
        });

        AssetManager assetManager = getAssets();

        try {

            AssetManager.AssetInputStream stream =  (AssetManager.AssetInputStream) assetManager.open("LocationData.csv");
            StringBuilder wholeCSV = new StringBuilder();

            // separating the stream result into int and char
            // int for checking for -1, char for adding to string builder
            int streamInt = stream.read();
            char streamChar = (char) streamInt;


            while (streamInt != -1) {
                String streamString = Character.toString(streamChar);
                wholeCSV.append(streamString);
                streamInt = stream.read();
                streamChar = (char) streamInt;
            }

            stream.close();

            CSVParser parser = new CSVParser(wholeCSV.toString());
            parser.createLocations();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
