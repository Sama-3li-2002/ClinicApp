package com.suhail.clinicapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.databinding.ActivitySplachBinding;

public class SplachActivity extends AppCompatActivity {
ActivitySplachBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplachActivity.this, LoginScreen.class));
                finish();
            }
        }, 1500);
    }
}