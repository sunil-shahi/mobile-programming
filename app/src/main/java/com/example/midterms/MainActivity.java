package com.example.midterms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button firstButton;
    private Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        firstButton = findViewById(R.id.firstButton);
        secondButton = findViewById(R.id.secondButton);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                sendDataToFragments(data);
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        loadFragments();
    }

    private void loadFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container_1, new FirstFragment());
        fragmentTransaction.add(R.id.fragment_container_2, new SecondFragment());
        fragmentTransaction.commit();
    }

    private void sendDataToFragments(String data) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentById(R.id.fragment_container_1);
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.fragment_container_2);

        if (firstFragment != null && secondFragment != null) {
            firstFragment.updateData(data);
            secondFragment.updateData(data);
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to navigate to another activity?")
                .setPositiveButton("OK", (dialog, id) -> {
                    Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                    startActivity(intent);
                })
                .setNegativeButton("Cancel", (dialog, id) -> dialog.dismiss())
                .create()
                .show();
    }

    public void updateTextView(String s) {
    }
}