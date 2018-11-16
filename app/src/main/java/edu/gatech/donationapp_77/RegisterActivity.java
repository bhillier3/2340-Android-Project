package edu.gatech.donationapp_77;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;
    private Spinner typeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = findViewById(R.id.regButton);
        Button cancelButton = findViewById(R.id.canButton);
        usernameText = findViewById(R.id.editTextName);
        emailText = findViewById(R.id.editTextEmail);
        passwordText = findViewById(R.id.editTextPass);

        typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<UserType> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, UserType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

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
        UserType type = (UserType) typeSpinner.getSelectedItem();

        User newUser = new User(name, email, password, type, null);

        if (!(email.isEmpty()) && !(password.isEmpty())) {

            if (User.getUserList().contains(newUser)) {
                emailText.setError("This user already exists. Did you mean to login?");
            } else {
                User.addUser(newUser);

                // log in
                User.setLoggedInUser(newUser);
                Log.d("DEBUG", "Logging in user " + newUser);

                startActivity(new Intent(RegisterActivity.this, HomeScreenActivity.class));
                emailText.getText().clear();
                passwordText.getText().clear();
            }

        } else if ((email.length() < 1) && (password.length() < 1)) {
            emailText.setError("Please enter an email");
            passwordText.setError("Please enter a password");
        } else {
            passwordText.setError("Please enter a password");
        }


    }
}
