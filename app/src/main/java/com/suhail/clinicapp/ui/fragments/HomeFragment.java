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

        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {activity.navController.navigate(R.id.nav_notifications);}
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


        //START view pager2 with image slider -- services
        ArrayList<ClinicService> clinicService = new ArrayList<>();

        clinicService.add(new ClinicService(R.drawable.consultation_service,getResources().getString(R.string.txt_consultation)));
        clinicService.add(new ClinicService(R.drawable.bestdoctors_service,getResources().getString(R.string.txt_best_doctor)));
        clinicService.add(new ClinicService(R.drawable.appointment_booking_service,getResources().getString(R.string.txt_appointment_booking)));
        clinicService.add(new ClinicService(R.drawable.consultation_service,getResources().getString(R.string.txt_consultation)));

         binding.viewPager2.setAdapter(new ClinicPagerAdapter(getActivity(),clinicService, binding.viewPager2));
//          worm Dots Indicator for Viewpager
         binding.wormDotsIndicator.attachTo(binding.viewPager2);


         binding.viewPager2.setOffscreenPageLimit(3);
//        setOffscreenPageLimit ---To set the number of pages that should be retained to either side of the currently visible page(s).
         binding.viewPager2.setClipChildren(false);
//         clipChildren --the FrameLayout that is at the root of the ViewPager needs to have clipping disabled.
         binding.viewPager2.setClipToPadding(false);
         binding.viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer transformer = new CompositePageTransformer();
//        CompositePageTransformer --- Allows for combining multiple PageTransformer objects.
        transformer.addTransformer(new MarginPageTransformer(0));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
//                 transformPage --- Allows for combining multiple PageTransformer objects.
                float r = 1- Math.abs(position);
                page.setScaleY(0.58f + r *0.14f);
            }
        });
        binding.viewPager2.setPageTransformer(transformer);
        //END view pager


        return binding.getRoot();
    }
}