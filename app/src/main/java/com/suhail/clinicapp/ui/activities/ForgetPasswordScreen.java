package com.suhail.clinicapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.ActivityForgetPasswordScreenBinding;


public class ForgetPasswordScreen extends AppCompatActivity {
    ActivityForgetPasswordScreenBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgetPasswordScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPasswordScreen.this,OtpCode.class));
            }
        });

        binding.cvForgotPassword.setBackgroundResource(R.drawable.custom_card_shape);
    }
}
