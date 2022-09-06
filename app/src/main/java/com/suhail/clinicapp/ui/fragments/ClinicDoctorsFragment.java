package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.ClinicDrAdapter;
import com.suhail.clinicapp.adapters.Doctor;
import com.suhail.clinicapp.adapters.NotificationsRvAdapter;
import com.suhail.clinicapp.databinding.FragmentClinicDoctorsBinding;
import com.suhail.clinicapp.databinding.TestBinding;
import com.suhail.clinicapp.models.Notification;

import java.util.ArrayList;
import java.util.List;


public class ClinicDoctorsFragment extends Fragment {
FragmentClinicDoctorsBinding binding;
    List<Doctor> clnicdoctor = new ArrayList<>();
    ClinicDrAdapter clinicDrAdapter ;
    public ClinicDoctorsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentClinicDoctorsBinding.inflate(getLayoutInflater());
        clnicdoctor.add(new Doctor("malk fhamra"  , "malk fhamra"));
        clnicdoctor.add(new Doctor("malk fhamra"  , "malk fhamra"));
        clnicdoctor.add(new Doctor("malk fhamra"  , "malk fhamra"));
        binding.rvDoctordebart.setLayoutManager(new LinearLayoutManager(getActivity()));
        clinicDrAdapter = new ClinicDrAdapter(getActivity() ,clnicdoctor);
        binding.rvDoctordebart.setAdapter(clinicDrAdapter);

        return binding.getRoot();
    }
}