package com.suhail.clinicapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.ActivityAddClinicBinding;
import com.suhail.clinicapp.databinding.ActivityForgetPasswordScreenBinding;

public class AddClinic extends AppCompatActivity {

    ActivityAddClinicBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityAddClinicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.cvAddClinic.setBackgroundResource(R.drawable.custom_card_shape);
        binding.cvAddClinic.setCardBackgroundColor(getResources().getColor(R.color.white));
    }
}