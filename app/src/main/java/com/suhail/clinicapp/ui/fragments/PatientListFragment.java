package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.PatientRvAdapter;
import com.suhail.clinicapp.databinding.FragmentPatientListBinding;
import com.suhail.clinicapp.listeners.OnPatientSelectedListener;
import com.suhail.clinicapp.models.Patient;
import com.suhail.clinicapp.models.PatientDetails;
import com.suhail.clinicapp.viewModel.CustomPatientListViewModel;
import com.suhail.clinicapp.viewModel.MedicalDiagnosisViewModel;

import java.util.ArrayList;


public class PatientListFragment extends Fragment {

    MainActivity activity;
    CustomPatientListViewModel customPatientListViewModel;
    public PatientListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        customPatientListViewModel = new ViewModelProvider(this).get(CustomPatientListViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentPatientListBinding binding = FragmentPatientListBinding.inflate(getLayoutInflater());

        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.navController.navigate(R.id.nav_notifications);
            }
        });


        customPatientListViewModel.getPateint().observe(getActivity(), new Observer<ArrayList<Patient>>() {
            @Override
            public void onChanged(ArrayList<Patient> patientDetails) {
                binding.rvPatientsList.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvPatientsList.setAdapter(new PatientRvAdapter(getActivity(), patientDetails, new OnPatientSelectedListener() {
                    @Override
                    public void onPatientSelected(Patient patient) {
                    activity.navController.navigate(R.id.nav_medicat_diagnosis);
                        MedicalDiagnosisViewModel.patientDetails = patient;
                    }
                }));
            }
        });

        return binding.getRoot();
    }
}