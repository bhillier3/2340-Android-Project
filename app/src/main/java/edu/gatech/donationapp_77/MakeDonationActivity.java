package edu.gatech.donationapp_77;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MakeDonationActivity extends AppCompatActivity {

    private Button cancel;
    private Button submit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_donation);

        cancel = (Button) findViewById(R.id.cancelButton);
        submit = (Button) findViewById(R.id.donateButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeDonation();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void makeDonation() {
        // Create new Item object
        // Go to item's page
//        startActivity(new Intent(this, ItemActivity.class));
    }
}
