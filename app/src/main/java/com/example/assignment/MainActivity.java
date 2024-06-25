package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText emailInput, passwordInput;

    Button submitBtn;
    Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailInput=findViewById(R.id.email_input);
        passwordInput=findViewById(R.id.password_input);
        submitBtn=findViewById(R.id.submit_btn);
        genderSpinner=findViewById(R.id.gender_spinner);

        submitBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email_input=String.valueOf(emailInput.getText());
                String password_input=String.valueOf(passwordInput.getText());
                String gender_input=String.valueOf(genderSpinner.getSelectedItem());
                //Toast.makeText(MainActivity.this, "Email:"+email_input + "\n" + "Password:" + password_input, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,HomePage.class);
                intent.putExtra("email",email_input);
                intent.putExtra("password",password_input);
                intent.putExtra("gender",gender_input);
                startActivity(intent);
            }
        });



    }
}