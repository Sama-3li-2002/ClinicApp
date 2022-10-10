package com.suhail.clinicapp.ui.fragments;

import android.content.Context;
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
import com.suhail.clinicapp.databinding.FragmentDoctorAppointmentBinding;
import com.suhail.clinicapp.listeners.OnPatientSelectedListener;
import com.suhail.clinicapp.models.Patient;
import com.suhail.clinicapp.models.PatientDetails;
import com.suhail.clinicapp.viewModel.CustomPatientListViewModel;
import com.suhail.clinicapp.viewModel.MedicalDiagnosisViewModel;

import java.util.ArrayList;


public class AppointmentsDoctorFragment extends Fragment {
    CustomPatientListViewModel customPatientListViewModel;
      MainActivity activity;

    public AppointmentsDoctorFragment() {
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
        FragmentDoctorAppointmentBinding binding = FragmentDoctorAppointmentBinding.inflate(getLayoutInflater());

        customPatientListViewModel.getPateint().observe(getActivity(), new Observer<ArrayList<Patient>>() {
            @Override
            public void onChanged(ArrayList<Patient> patients) {
                binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rv.setAdapter(new PatientRvAdapter(getActivity(), patients, new OnPatientSelectedListener() {
                    @Override
                    public void onPatientSelected(Patient patient) {
                        activity.navController.navigate(R.id.nav_medicat_diagnosis);
                        MedicalDiagnosisViewModel.patientDetails = patient;
                    }
                }));
            }
        });
        binding.btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnNew.setBackgroundResource(R.drawable.shape_btn_clicked);
                binding.btnNew.setTextAppearance(getContext(),R.style.style_btn_clicked);
                binding.btnReview.setBackgroundResource(R.drawable.shape_btn_unclicked);
                binding.btnReview.setTextAppearance(getContext(),R.style.style_btn_unclicked);

                customPatientListViewModel.getPateint().observe(getActivity(), new Observer<ArrayList<Patient>>() {
                    @Override
                    public void onChanged(ArrayList<Patient> patients) {
                        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
                        binding.rv.setAdapter(new PatientRvAdapter(getActivity(), patients, new OnPatientSelectedListener() {
                            @Override
                            public void onPatientSelected(Patient patient) {
                                activity.navController.navigate(R.id.nav_medicat_diagnosis);
                                MedicalDiagnosisViewModel.patientDetails = patient;
                            }
                        }));
                    }
                });
                    }
                });


        binding.btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnReview.setBackgroundResource(R.drawable.shape_btn_clicked);
                binding.btnReview.setTextAppearance(getContext(),R.style.style_btn_clicked);
                binding.btnNew.setBackgroundResource(R.drawable.shape_btn_unclicked);
                binding.btnNew.setTextAppearance(getContext(),R.style.style_btn_unclicked);

                customPatientListViewModel.getPateint().observe(getActivity(), new Observer<ArrayList<Patient>>() {
                    @Override
                    public void onChanged(ArrayList<Patient> patients) {
                        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
                        binding.rv.setAdapter(new PatientRvAdapter(getActivity(), patients, new OnPatientSelectedListener() {
                            @Override
                            public void onPatientSelected(Patient patient) {
                                activity.navController.navigate(R.id.nav_medicat_diagnosis);
                                MedicalDiagnosisViewModel.patientDetails = patient;
                            }
                        }));
                    }
                });
            }
        });

    return binding.getRoot();
    }
}