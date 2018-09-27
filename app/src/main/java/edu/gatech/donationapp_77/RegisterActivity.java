package edu.gatech.donationapp_77;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private Button registerButton;
    private Button cancelButton;
    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerButton = findViewById(R.id.regButton);
        cancelButton = findViewById(R.id.canButton);
        usernameText = findViewById(R.id.editTextName);
        emailText = findViewById(R.id.editTextEmail);
        passwordText = findViewById(R.id.editTextPass);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void register() {
        String name = usernameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        User newUser = new User(email, password, UserType.EMPLOYEE);

        User.addUser(newUser);
        System.out.println(User.getUserList());

        startActivity(new Intent(RegisterActivity.this, HomeScreenActivity.class));
        emailText.getText().clear();
        passwordText.getText().clear();

    }
}
