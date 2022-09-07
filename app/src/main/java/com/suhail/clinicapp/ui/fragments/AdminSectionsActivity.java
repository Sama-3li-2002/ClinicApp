package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.suhail.clinicapp.databinding.ActivityAdminSectionsBinding;

public class AdminSectionsActivity extends AppCompatActivity {
ActivityAdminSectionsBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminSectionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
