package edu.gatech.donationapp_77;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity2 extends AppCompatActivity {

    private Button signInButton;
    private Button cancelButton;
    private EditText emailText;
    private EditText passwordText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Dummy Users for testing purposes
        User.addUser(new User("Foo", "foo@example.com", "hello", UserType.EMPLOYEE, Location.getLocationList().get(0)));
        User.addUser(new User("Bar", "bar@example.com", "world", UserType.EMPLOYEE, Location.getLocationList().get(1)));

        signInButton = (Button) findViewById(R.id.email_sign_in_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        System.out.println(User.getUserList());
    }

    private void login() {
//      Store values at the time of the login attempt.
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        User givenUser = new User(email, password);

        if (email.length() > 0 && password.length() > 0) {
//      Check that email and password match.
            if (!isValidPassword(givenUser)) {
                passwordText.setError("Email/password combo does not match.");
            } else {
                // Perform the user login attempt.
                givenUser = User.getUserList().get(User.getUserList().indexOf(givenUser));
                User.setLoggedInUser(givenUser);
                startActivity(new Intent(LoginActivity2.this, HomeScreenActivity.class));
                emailText.getText().clear();
                passwordText.getText().clear();
            }
        } else if (email.length() < 1) {
            emailText.setError("Please enter an email");
        } else {
            passwordText.setError("Please enter a password");
        }
    }

    private boolean isValidPassword(User user) {
        return User.getUserList().contains(user);
    }
}