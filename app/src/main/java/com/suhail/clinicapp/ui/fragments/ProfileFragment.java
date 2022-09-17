package com.suhail.clinicapp.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.FragmentProfileBinding;

import java.util.function.ObjIntConsumer;


public class ProfileFragment extends Fragment {
    MainActivity activity;
    Uri uri;
    FragmentProfileBinding binding;
    ActivityResultLauncher<Intent> launcher;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        binding = FragmentProfileBinding.inflate(getLayoutInflater());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding.btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                launcher.launch(intent);
            }
        });

        binding.btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_settings);
            }
        });

        binding.cvProfile.setBackgroundResource(R.drawable.custom_card_shape);

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.etName.setEnabled(true);
                binding.etEmail.setEnabled(true);
                binding.etAddress.setEnabled(true);
                binding.etPhone.setEnabled(true);
                binding.etPassword.setEnabled(true);
                binding.btnEdit.setVisibility(View.INVISIBLE);
                binding.btnTakePic.setVisibility(View.VISIBLE);
            }
        });


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_profile);
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

                launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        uri = result.getData().getData();
                        if (uri != null)
                            binding.ivProfilePic1.setImageURI(uri);
                    }
                });


    }}