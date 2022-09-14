package com.suhail.clinicapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.ActivityTypeUsersBinding;

public class TypeUsersActivity extends AppCompatActivity implements View.OnClickListener {

ActivityTypeUsersBinding binding;
public static final String USER_TYPE_KEY = "userType";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTypeUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnPatient.setOnClickListener(this);
        binding.btnAdmin.setOnClickListener(this);
        binding.btnDoctor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int userType=1;
        switch (v.getId()){
            case R.id.btn_patient:
                userType = 1;
                break;
            case R.id.btn_Admin:
                userType = 2;
                break;
            case R.id.btn_doctor:
                userType = 3;
                break;
        }
        Intent intent = new Intent(TypeUsersActivity.this,LoginScreen.class);
        intent.putExtra(USER_TYPE_KEY,userType);
        startActivity(intent);
    }
}