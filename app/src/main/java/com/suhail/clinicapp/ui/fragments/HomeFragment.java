package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.ClinicRvAdapter;
import com.suhail.clinicapp.databinding.FragmentHomeBinding;
import com.suhail.clinicapp.models.Clinic;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding binding=FragmentHomeBinding.inflate(getLayoutInflater());
        List<Clinic> clinics=new ArrayList<>();
        clinics.add(new Clinic(R.drawable.clinic_profile,"Clinic","Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile,"Clinic","Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile,"Clinic","Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile,"Clinic","Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile,"Clinic","Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile,"Clinic","Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile,"Clinic","Gaza,First Street"));

        ClinicRvAdapter adapter=new ClinicRvAdapter(getActivity(),clinics);
        binding.rvClincs.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvClincs.setAdapter(adapter);
        return binding.getRoot();
    }
}