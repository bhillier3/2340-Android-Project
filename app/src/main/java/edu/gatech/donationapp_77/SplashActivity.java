package edu.gatech.donationapp_77;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.File;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button registerButton = (Button) findViewById(R.id.registerButton);

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
