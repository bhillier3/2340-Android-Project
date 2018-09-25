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

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final User[] DUMMY_CREDENTIALS = new User[]{
            new User("foo@example.com", "hello", UserType.EMPLOYEE),
            new User("bar@example.com", "world", UserType.EMPLOYEE)
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
    }

    private void login() {
//      Store values at the time of the login attempt.
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        User givenUser = new User(email, password, UserType.EMPLOYEE);
        List<User> loginList = Arrays.asList(DUMMY_CREDENTIALS);

//      Check that email and password match.
        if (!loginList.contains(givenUser)) {
            passwordText.setError("Email/password combo does not match.");
        } else {
            // Perform the user login attempt.
            startActivity(new Intent(LoginActivity2.this, HomeScreenActivity.class));
            emailText.getText().clear();
            passwordText.getText().clear();
        }
    }
}