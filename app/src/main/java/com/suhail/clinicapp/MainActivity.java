package com.suhail.clinicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.suhail.clinicapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private AppBarConfiguration configuration;
    public static NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initNavigation();
    }


    private void initNavigation() {
        configuration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_appotiments, R.id.nav_all_clinic, R.id.nav_profile,
                R.id.nav_booking, R.id.nav_notifications, R.id.nav_settings, R.id.nav_map,
                R.id.nav_empty_data, R.id.nav_doctors, R.id.nav_departments, R.id.nav_doctor_details
        ).build();
        navController = Navigation.findNavController(this, R.id.nav_host_name);
        NavigationUI.setupWithNavController(binding.bottomNav, navController);
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btn_home:
                        navController.navigate(R.id.nav_home);
                        break;
                    case R.id.btn_appoitments:
                        navController.navigate(R.id.nav_appotiments);
                        break;
                    case R.id.btn_clinics:
                        navController.navigate(R.id.nav_all_clinic);
                        break;
                    case R.id.btn_profile:
                        navController.navigate(R.id.nav_profile);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        navController.navigate(R.id.nav_home);
        binding.bottomNav.setSelectedItemId(R.id.btn_home);
    }
}