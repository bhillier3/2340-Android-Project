package edu.gatech.donationapp_77;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A login screen that offers login via email/password.
 */
@SuppressWarnings("CyclicClassDependency")
public class LoginActivity2 extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        List<Location> list = Location.getLocationList();
        // Dummy Users for testing purposes
        User.addUser(new User("Foo", "foo@example.com", "hello",
                UserType.EMPLOYEE, list.get(0)));
        User.addUser(new User("Bar", "bar@example.com", "world",
                UserType.EMPLOYEE, list.get(1)));

        Button signInButton = findViewById(R.id.email_sign_in_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);

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
        Editable emailEditable = emailText.getText();
        String email = emailEditable.toString();
        Editable passEditable = passwordText.getText();
        String password = passEditable.toString();
        User givenUser = new User(email, password);

        if (!(email.isEmpty()) && !(password.isEmpty())) {
//      Check that email and password match.
            if (!isValidPassword(givenUser)) {
                passwordText.setError("Email/password combo does not match.");
            } else {
                // Perform the user login attempt.
                List<User> userList = User.getUserList();
                int userIndex = userList.indexOf(givenUser);
                givenUser = userList.get(userIndex);
                //
                User.setLoggedInUser(givenUser);
                startActivity(new Intent(LoginActivity2.this, HomeScreenActivity.class));
                emailEditable.clear();
                passEditable.clear();
            }
        } else if (email.length() < 1) {
            emailText.setError("Please enter an email");
        } else {
            passwordText.setError("Please enter a password");
        }
    }

    /**
     * Determines if a password is valid
     * @param user the user whose password is checking
     * @return if it's valid
     */
    public static boolean isValidPassword(User user) {
        List<User> userList = User.getUserList();
        return userList.contains(user);
    }
}