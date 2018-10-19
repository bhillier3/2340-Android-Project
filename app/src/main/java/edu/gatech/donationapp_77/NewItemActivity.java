package edu.gatech.donationapp_77;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewItemActivity extends Activity {

    private TextView titleText;
    private EditText nameF;
    private EditText valueF;
    private EditText quantityF;
    private EditText descriptionF;

    private Button submitButton;
    private Button cancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        setFieldVariables();


    }


    private void setFieldVariables() {
        titleText = findViewById(R.id.titleView);
        nameF = findViewById(R.id.nameField);
        valueF = findViewById(R.id.valueField);
        quantityF = findViewById(R.id.quantityField);
        descriptionF = findViewById(R.id.descriptionField);

        submitButton = findViewById(R.id.itemSubmitButton);
        cancelButton = findViewById(R.id.itemCancelButton);

    }

}
