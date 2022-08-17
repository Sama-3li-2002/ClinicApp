package com.suhail.clinicapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.ActivityOtpCodeBinding;

public class OtpCode extends AppCompatActivity {
ActivityOtpCodeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}