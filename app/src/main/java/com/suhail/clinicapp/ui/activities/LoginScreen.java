package com.suhail.clinicapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.suhail.clinicapp.R;

public class LoginScreen extends AppCompatActivity {
    TextView clicksignin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        clicksignin =findViewById(R.id.tv_signin);
        clicksignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(LoginScreen.this,CreateAccount.class);
               startActivity(intent);
            }
        });
    }
}