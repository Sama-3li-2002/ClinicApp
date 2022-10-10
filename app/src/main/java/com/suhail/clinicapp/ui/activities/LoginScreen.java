package com.suhail.clinicapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity {
    ActivityLoginScreenBinding binding;
    int usertype = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getIntent() != null){
            usertype = getIntent().getIntExtra(TypeUsersActivity.USER_TYPE_KEY,1);
        }
        switch (usertype){
            case 1 :
                binding.btnSignUp.setVisibility(View.VISIBLE);
                break;
        }
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (usertype){
                    case 1:
                        startActivity(new Intent(LoginScreen.this, MainActivity.class).putExtra("userType",usertype));
                        break;
                    case 2:
                        startActivity(new Intent(LoginScreen.this, MainActivity.class).putExtra("userType",usertype));
                        break;
                    case 3:
                        startActivity(new Intent(LoginScreen.this, MainActivity.class).putExtra("userType",usertype));
                }

            }
        });

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this,CreateAccount.class));
            }
        });

        binding.btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this,ForgetPasswordScreen.class));
            }
        });
        binding.cvLogin.setBackgroundResource(R.drawable.custom_card_shape);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}