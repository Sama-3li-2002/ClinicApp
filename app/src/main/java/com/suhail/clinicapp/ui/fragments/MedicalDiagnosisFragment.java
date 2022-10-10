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
import com.suhail.clinicapp.adapters.AppotimentsRvAdapter;
import com.suhail.clinicapp.adapters.TreatmentRvAdapter;
import com.suhail.clinicapp.databinding.FragmentMedicalDiagnosisBinding;
import com.suhail.clinicapp.models.Appoitment;
import com.suhail.clinicapp.models.PatientDetails;
import com.suhail.clinicapp.viewModel.MedicalDiagnosisViewModel;

import java.util.ArrayList;
import java.util.List;


public class MedicalDiagnosisFragment extends Fragment {
    MainActivity activity;
    FragmentMedicalDiagnosisBinding binding;
    MedicalDiagnosisViewModel medicalDiagnosisViewModel;
    public MedicalDiagnosisFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity =(MainActivity) getActivity();
        medicalDiagnosisViewModel = new ViewModelProvider(this).get(MedicalDiagnosisViewModel.class);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentMedicalDiagnosisBinding.inflate(getLayoutInflater());

        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.navController.navigate(R.id.nav_notifications);
            }
        });



        medicalDiagnosisViewModel.getPatientOneDetails().observe(getActivity(), new Observer<PatientDetails>() {
            @Override
            public void onChanged(PatientDetails patientDetails) {
                 binding.setData(patientDetails);
                 binding.rvTreatment.setLayoutManager( new  LinearLayoutManager(getContext()));
                 binding.rvReview.setLayoutManager(new LinearLayoutManager(getContext()));
                 binding.rvTreatment.setAdapter(new TreatmentRvAdapter(getContext(),patientDetails.getTreatmentList()));

                List<Appoitment> appoitment = new ArrayList<>();
                appoitment.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));

                 binding.rvReview.setAdapter(new AppotimentsRvAdapter(getContext(),appoitment));

            }
        });

        return binding.getRoot();
    }
}

