package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.DepartmentsRvAdapter;
import com.suhail.clinicapp.adapters.NotificationsRvAdapter;
import com.suhail.clinicapp.databinding.FragmentDepartmentsBinding;
import com.suhail.clinicapp.models.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsFragment extends Fragment {
    MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity= (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDepartmentsBinding binding=FragmentDepartmentsBinding.inflate(getLayoutInflater());
        if(getArguments()!=null){
            binding.tvClinicName.setText(getArguments().getString("clinicName"));
        }

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_home);
            }
        });
        binding.btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_map);
            }
        });
        List<Department> departments=new ArrayList<>();
        departments.add(new Department("Heart"));
        departments.add(new Department("Heart"));
        departments.add(new Department("Heart"));
        departments.add(new Department("Heart"));
        departments.add(new Department("Heart"));
        departments.add(new Department("Heart"));
        departments.add(new Department("Heart"));
        departments.add(new Department("Heart"));

        binding.rvDepartments.setLayoutManager(new GridLayoutManager(getActivity(),2));
        binding.rvDepartments.setAdapter(new DepartmentsRvAdapter(departments));
        return binding.getRoot();
    }
}
