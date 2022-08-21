package com.suhail.clinicapp.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.FragmentSettingsBinding;
import com.suhail.clinicapp.ui.activities.LoginScreen;

public class SettingsFragment extends Fragment {

    MainActivity activity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity= (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSettingsBinding binding=FragmentSettingsBinding.inflate(getLayoutInflater());
        binding.btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivEnglishCheck.setVisibility(View.VISIBLE);
                binding.ivArabicCheck.setVisibility(View.GONE);
            }
        });

        binding.btnArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivArabicCheck.setVisibility(View.VISIBLE);
                binding.ivEnglishCheck.setVisibility(View.GONE);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_profile);
            }
        });

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginScreen.class));
            }
        });
        return binding.getRoot();
        }
}
