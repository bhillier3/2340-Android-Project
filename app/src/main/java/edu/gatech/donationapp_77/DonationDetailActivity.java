package edu.gatech.donationapp_77;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DonationDetailActivity extends AppCompatActivity {

    private String itemName;
    private double itemValue;
    private int itemQty;
    private String itemDesc;
    private String itemComments;
    private String itemCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_detail);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Intent incoming = getIntent();
        itemName = incoming.getStringExtra("itemName");
        itemValue = incoming.getDoubleExtra("itemValue", 0.0);
        itemQty = incoming.getIntExtra("itemQty", 0);
        itemDesc = incoming.getStringExtra("itemDesc");
        itemComments = incoming.getStringExtra("itemComments");
        itemCat = incoming.getStringExtra("itemCategory");

        setItemData(itemName, itemValue, itemQty, itemDesc, itemComments);
    }

    private void setItemData(String name, double value, int quantity, String description,
                             String comments) {
        TextView donName = findViewById(R.id.donNameText);
        TextView donVal = findViewById(R.id.donValueText);
        TextView donQty = findViewById(R.id.donQuantText);
        TextView donDesc = findViewById(R.id.donDescText);
        TextView donCom = findViewById(R.id.donCommText);
        TextView donCat = findViewById(R.id.donCatText);

        donName.setText(itemName);
        donVal.setText("Value: $" + String.valueOf(itemValue));
        donQty.setText("Qty: " + String.valueOf(itemQty));
        donDesc.setText(itemDesc);
        donCom.setText(itemComments);
        donCat.setText(itemCat);
    }
}
