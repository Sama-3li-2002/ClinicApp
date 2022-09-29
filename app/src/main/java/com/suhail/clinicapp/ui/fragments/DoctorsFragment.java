package com.suhail.clinicapp.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.DoctorsRvAdapter;
import com.suhail.clinicapp.databinding.FragmentClinicDoctorsBinding;
import com.suhail.clinicapp.listeners.OnDoctorSelectedListener;
import com.suhail.clinicapp.models.DoctorDetails;
import com.suhail.clinicapp.ui.activities.AddDoctor;
import com.suhail.clinicapp.viewModel.CustomDoctorLayoutViewModel;
import com.suhail.clinicapp.viewModel.DoctorViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoctorsFragment extends Fragment {
    String deptName;
    MainActivity activity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        if(getArguments() != null){
            deptName = getArguments().getString("deptName");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentClinicDoctorsBinding binding = FragmentClinicDoctorsBinding.inflate(getLayoutInflater());

        if(MainActivity.userType == MainActivity.ADMIN_KEY)
        {
         binding.btnMap.setVisibility(View.GONE);
         binding.btnAdd.setVisibility(View.VISIBLE);
        }

        if(deptName != null)
        binding.tvDepartmentName.setText(deptName);


        CustomDoctorLayoutViewModel v = new CustomDoctorLayoutViewModel();
        v.getDoctors();
        List<CustomDoctorLayoutViewModel> list = new ArrayList<>();

      list.add(v);
      list.add(v);
      list.add(v);
      list.add(v);
      list.add(v);

        binding.rvDoctordebart.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvDoctordebart.setAdapter(new DoctorsRvAdapter(getContext(), list, new OnDoctorSelectedListener() {
            @Override
            public void onDoctorSelected(DoctorDetails details) {
                DoctorViewModel.details = details;
                activity.navController.navigate(R.id.nav_doctor_details);
            }
        }));

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddDoctor.class));
            }
        });

        return binding.getRoot();
    }

}
