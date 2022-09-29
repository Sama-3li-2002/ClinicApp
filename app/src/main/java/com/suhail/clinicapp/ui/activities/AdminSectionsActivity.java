package com.suhail.clinicapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        binding.btnDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}
