package com.suhail.clinicapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.ActivityAddDoctorBinding;

public class AddDoctor extends AppCompatActivity {

    ActivityAddDoctorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityAddDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.cvAddClinic.setBackgroundResource(R.drawable.custom_card_shape);
        binding.cvAddClinic.setCardBackgroundColor(getResources().getColor(R.color.white));
        binding.cvLegalPaper.setBackgroundResource(R.drawable.custom_card_shape);
    }
}