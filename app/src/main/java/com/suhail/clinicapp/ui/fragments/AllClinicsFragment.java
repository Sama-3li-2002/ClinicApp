package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.ClinicRvAdapter;
import com.suhail.clinicapp.databinding.BottomSheetLayoutBinding;
import com.suhail.clinicapp.databinding.FragmentAllClinicsBinding;
import com.suhail.clinicapp.databinding.FragmentHomeBinding;
import com.suhail.clinicapp.listeners.OnClinicClickedListener;
import com.suhail.clinicapp.models.Clinic;
import com.suhail.clinicapp.models.DoctorDetails;
import com.suhail.clinicapp.models.ExperienceWorkplace;

import java.util.ArrayList;
import java.util.List;

public class AllClinicsFragment extends Fragment {

    MainActivity activity;

    public AllClinicsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAllClinicsBinding binding =FragmentAllClinicsBinding.inflate(getLayoutInflater());

        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {activity.navController.navigate(R.id.nav_notifications);}
        });

        List<Clinic> clinics = new ArrayList<>();
        clinics.add(new Clinic(R.drawable.clinic_profile, "Heart Clinic", "Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile, "Dental Clinic", "Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile, "Surgery Clinic", "Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile, "Ortho Clinic", "Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile, "Clinic", "Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile, "Clinic", "Gaza,First Street"));
        clinics.add(new Clinic(R.drawable.clinic_profile, "Clinic", "Gaza,First Street"));

        ClinicRvAdapter adapter = new ClinicRvAdapter(getActivity(), clinics, new OnClinicClickedListener() {
            @Override
            public void onClinicClicked(String clinicName) {
                Bundle bundle=new Bundle();
                bundle.putString("clinicName",clinicName);
                activity.navController.navigate(R.id.nav_departments,bundle);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.rvClincs.setLayoutManager(layoutManager);
        binding.rvClincs.setHasFixedSize(true);
        binding.rvClincs.setAdapter(adapter);


        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_doctor_details);
            }
        });

        binding.btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        return binding.getRoot();
    }

    public void showBottomSheet(){
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(),R.style.BottomSheetDialog);
        BottomSheetLayoutBinding binding = BottomSheetLayoutBinding.inflate(getLayoutInflater());
        dialog.setContentView(binding.getRoot());
        List<String> centersNames = new ArrayList<>();
        centersNames.add("ACenter");
        centersNames.add("BCenter");
        centersNames.add("CCenter");
        centersNames.add("DCenter");

        List<String> clinicsNames = new ArrayList<>();
        clinicsNames.add("Dental Clinic");
        clinicsNames.add("Ortho Clinic");
        clinicsNames.add("AH Clinic");
        clinicsNames.add("DC Clinic");

        List<String> departmentsNames = new ArrayList<>();
        departmentsNames.add("Cardio");
        departmentsNames.add("Surgery");
        departmentsNames.add("Ortho");

        ArrayAdapter<String> centersAdapter = new ArrayAdapter<String>(getActivity(),R.layout.custom_spinner_layout,centersNames);
        ArrayAdapter<String> clinicsAdapter = new ArrayAdapter<String>(getActivity(),R.layout.custom_spinner_layout,clinicsNames);
        ArrayAdapter<String> departmentsAdapter = new ArrayAdapter<String>(getActivity(),R.layout.custom_spinner_layout,departmentsNames);

        binding.spCenters.setAdapter(centersAdapter);
        binding.spClinics.setAdapter(clinicsAdapter);
        binding.spDepartments.setAdapter(departmentsAdapter);

        dialog.show();
    }
}