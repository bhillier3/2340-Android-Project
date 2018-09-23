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
    private EditText emailText;
    private EditText passwordText;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInButton = (Button) findViewById(R.id.email_sign_in_button);
        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        // Store values at the time of the login attempt.
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        boolean cancel = false;

//         Check that email and password match.
        if (!isValidLoginCombo(email, password)) {
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login
            passwordText.setError("Email/password combo does not match.");
//            finish();
        } else {
            // Perform the user login attempt.
            startActivity(new Intent(LoginActivity2.this, HomeScreenActivity.class));
        }
    }

    private boolean isValidLoginCombo(String email, String password) {
        List<String> loginList = Arrays.asList(DUMMY_CREDENTIALS);
        ArrayList<String> emailList = new ArrayList<>();
        ArrayList<String> passwordList = new ArrayList<>();

        for (String login : loginList) {
            String subEmail = login.substring(0,login.indexOf(":"));
            String subPass = login.substring(login.indexOf(":") + 1);
            emailList.add(subEmail);
            passwordList.add(subPass);
        }

        int validationIndex = emailList.indexOf(email);

        System.out.println(emailList);
        System.out.println(passwordList);

        return (validationIndex == passwordList.indexOf(password)) && (validationIndex != -1);
    }
}