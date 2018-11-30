package edu.gatech.donationapp_77;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;

import java.util.List;

public class LockUnlockActivity extends AppCompatActivity {

    private User curUser;
    private Spinner userSpinner;
    private Switch lockSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_unlock);

        lockSwitch = findViewById(R.id.lockSwitch);
        lockSwitch.setText("Locked:");

        userSpinner = findViewById(R.id.userSpinner);
        List<User> userList = User.getUserList();
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, userList);
        userSpinner.setAdapter(adapter);

        curUser = (User) userSpinner.getItemAtPosition(0);
        lockSwitch.setChecked(curUser.isLocked());

        selectUser();
        lockSwitch();
    }

    private void selectUser() {
        userSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                curUser = (User) userSpinner.getItemAtPosition(position);
                lockSwitch.setChecked(curUser.isLocked());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void lockSwitch() {
        lockSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curUser.isLocked()) {
                    curUser.unlock();
                } else {
                    curUser.lock();
                }
                lockSwitch.setChecked(curUser.isLocked());
            }
        });
    }
}
