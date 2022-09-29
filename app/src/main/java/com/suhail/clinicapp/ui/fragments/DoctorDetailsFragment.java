package com.suhail.clinicapp.ui.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.ExperienceWorkplaceRvAdapter;
import com.suhail.clinicapp.adapters.ExperienceWorkplaceRvAdapter2;
import com.suhail.clinicapp.databinding.FragmentDoctorDetailsBinding;
import com.suhail.clinicapp.models.DoctorDetails;
import com.suhail.clinicapp.viewModel.DoctorViewModel;

public class DoctorDetailsFragment extends Fragment {

    DoctorViewModel doctorViewModel;
    MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doctorViewModel =  new ViewModelProvider(this).get(DoctorViewModel.class);
        activity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentDoctorDetailsBinding binding = FragmentDoctorDetailsBinding.inflate(getLayoutInflater());
        if(MainActivity.userType == MainActivity.ADMIN_KEY)
        {
            binding.btnBookAppointment.setVisibility(View.GONE);
            binding.btnPatientList.setVisibility(View.VISIBLE);
        }
        doctorViewModel.getDoctorONeDetails();
        binding.setViewModel(doctorViewModel);
        binding.setLifecycleOwner(this);


            doctorViewModel.mutableLiveData.observe(getActivity(), new Observer<DoctorDetails>() {
                @Override
                public void onChanged(DoctorDetails doctorDetails) {
                    //set the recycler of experience and workplaces
                    ExperienceWorkplaceRvAdapter2 experienceAdapter = new ExperienceWorkplaceRvAdapter2(doctorDetails.getExperienceList());
                    ExperienceWorkplaceRvAdapter2 workplaceAdapter = new ExperienceWorkplaceRvAdapter2(doctorDetails.getWorkplacesList());
                    binding.rvExperience.setLayoutManager(new LinearLayoutManager(getActivity()));
                    binding.rvWorkPlace.setLayoutManager(new LinearLayoutManager(getActivity()));
                    binding.rvExperience.setAdapter(experienceAdapter);
                    binding.rvWorkPlace.setAdapter(workplaceAdapter);

                }
            });

            binding.btnBookAppointment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.navController.navigate(R.id.nav_booking);
                }
            });
            binding.btnPatientList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "Patient List", Toast.LENGTH_SHORT).show();
                }
            });
        return binding.getRoot();
    }

}
