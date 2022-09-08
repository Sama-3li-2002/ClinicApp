package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.FragmentEmptyAppointmentBinding;
import com.suhail.clinicapp.databinding.FragmentHomeBinding;


public class EmptyAppointmentFragment extends Fragment {
        MainActivity activity;

    public EmptyAppointmentFragment() {
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
        FragmentEmptyAppointmentBinding binding =FragmentEmptyAppointmentBinding.inflate(getLayoutInflater());

        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {activity.navController.navigate(R.id.nav_notifications);}
        });

        return binding.getRoot();
    }
}