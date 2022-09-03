package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.suhail.clinicapp.databinding.CustomServiceLayout2Binding;
import com.suhail.clinicapp.databinding.CustomServiceLayoutBinding;
import com.suhail.clinicapp.models.ClinicService;

public class ClinicServiceFragment extends Fragment {
    private ClinicService clinicService;

    private ClinicServiceFragment() {
    }

    public static ClinicServiceFragment getInstance(ClinicService clinicService){
        ClinicServiceFragment fragment=new ClinicServiceFragment();
        Bundle args = new Bundle();
        args.putSerializable("data",clinicService);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            clinicService = (ClinicService) getArguments().getSerializable("data");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        CustomServiceLayout2Binding binding=CustomServiceLayout2Binding.inflate(getLayoutInflater());
        binding.ivServiceImage.setImageResource(clinicService.getImage());
        binding.tvServiceName.setText(clinicService.getServiceName());
        return binding.getRoot();
       // return super.onCreateView(inflater, container, savedInstanceState);
    }
}
