package com.suhail.clinicapp.ui.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.suhail.clinicapp.R;

public class TypeUsersActivity extends AppCompatActivity {
//iv_patent
ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_users);
        Toast.makeText(TypeUsersActivity.this ,"x" ,Toast.LENGTH_LONG).show();
        img1 =findViewById(R.id.iv_patent);
    }
}