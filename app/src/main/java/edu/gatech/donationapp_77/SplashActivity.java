package edu.gatech.donationapp_77;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.donationapp_77.LocationManagementFacade;
import edu.gatech.donationapp_77.Location;

import java.io.BufferedInputStream;
import java.io.File;

public class SplashActivity extends AppCompatActivity {

    LocationManagementFacade lmf = LocationManagementFacade.getInstance();
    UserManagementFacade umf = UserManagementFacade.getInstance();
    File file;
    File user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        Button saveJson = (Button) findViewById(R.id.saveJson);
        Button loadJson = (Button) findViewById(R.id.loadJson);

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

            // seperating the stream result into int and char
            // int for checking for -1, char for adding to stringbuilder
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
            System.out.println("Error starts here:");
            e.printStackTrace();
        }

    }

}
