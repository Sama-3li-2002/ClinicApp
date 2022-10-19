package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.FragmentDoctorProfileBinding;


public class DoctorProfileFragment extends Fragment {
   FragmentDoctorProfileBinding binding;
   MainActivity activity;
    public DoctorProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        binding = FragmentDoctorProfileBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding.cvDoctorProfile.setBackgroundResource(R.drawable.custom_card_shape);

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etName.setEnabled(true);
                binding.etAbout.setEnabled(true);
                binding.etAddress.setEnabled(true);
                binding.etAge.setEnabled(true);
                binding.etDeptName.setEnabled(true);
                binding.etEmail.setEnabled(true);
                binding.etPhone.setEnabled(true);
                binding.btnEdit.setVisibility(View.GONE);
                binding.btnTakePic.setVisibility(View.VISIBLE);
            }
        });
       return binding.getRoot();

    }
}