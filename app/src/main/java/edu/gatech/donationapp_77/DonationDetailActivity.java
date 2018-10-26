package edu.gatech.donationapp_77;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        itemName = getIntent().getStringExtra("itemName");
        itemValue = getIntent().getDoubleExtra("itemValue", 0.0);
        itemQty = getIntent().getIntExtra("itemQty", 0);
        itemDesc = getIntent().getStringExtra("itemDesc");
        itemComments = getIntent().getStringExtra("itemComments");
        itemCat = getIntent().getStringExtra("itemCategory");

        setItemData(itemName, itemValue, itemQty, itemDesc, itemComments);
    }

    private void setItemData(String name, double value, int quantity, String description, String comments) {
        TextView donName = (TextView) findViewById(R.id.donNameText);
        TextView donVal = (TextView) findViewById(R.id.donValueText);
        TextView donQty = (TextView) findViewById(R.id.donQuantText);
        TextView donDesc = (TextView) findViewById(R.id.donDescText);
        TextView donCom = (TextView) findViewById(R.id.donCommText);
        TextView donCat = findViewById(R.id.donCatText);

        donName.setText(itemName);
        donVal.setText("Value: $" + String.valueOf(itemValue));
        donQty.setText("Qty: " + String.valueOf(itemQty));
        donDesc.setText(itemDesc);
        donCom.setText(itemComments);
        donCat.setText(itemCat);
    }
}
