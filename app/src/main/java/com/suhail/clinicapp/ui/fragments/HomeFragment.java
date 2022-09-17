package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.ClinicPagerAdapter;
import com.suhail.clinicapp.adapters.ClinicRvAdapter;

import com.suhail.clinicapp.databinding.FragmentHomeBinding;
import com.suhail.clinicapp.listeners.OnClinicClickedListener;
import com.suhail.clinicapp.models.Clinic;
import com.suhail.clinicapp.models.ClinicService;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    MainActivity activity;


    public HomeFragment() {
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
        FragmentHomeBinding binding =FragmentHomeBinding.inflate(getLayoutInflater());

        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_notifications);
            }
        });

        binding.tvViewAllClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {activity.navController.navigate(R.id.nav_all_clinic);}
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
        binding.rvClinics.setLayoutManager(layoutManager);
        binding.rvClinics.setHasFixedSize(true);
        binding.rvClinics.setAdapter(adapter);

//button see all to open all clinics fragment
        binding.tvViewAllClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        activity.navController.navigate(R.id.nav_all_clinic);
            }
        });

        return binding.getRoot();
    }
}