package com.suhail.clinicapp.ui.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.suhail.clinicapp.adapters.ExperienceWorkplaceRvAdapter;
import com.suhail.clinicapp.databinding.FragmentDoctorDetailsBinding;
import com.suhail.clinicapp.models.DoctorDetails;
import com.suhail.clinicapp.viewModel.DoctorViewModel;

public class DoctorDetailsFragment extends Fragment {

    DoctorViewModel doctorViewModel ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doctorViewModel =  new ViewModelProvider(this).get(DoctorViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentDoctorDetailsBinding binding = FragmentDoctorDetailsBinding.inflate(getLayoutInflater());

        doctorViewModel.getDoctorONeDetails();
        binding.setViewModel(doctorViewModel);
        binding.setLifecycleOwner(this);



//            doctorViewModel.mutableLiveData.observe(getActivity(), new Observer<DoctorDetails>() {
//                @Override
//                public void onChanged(DoctorDetails doctorDetails) {
//                    //bind doctor details to fragment views
////                    binding.tvDoctorName.setText(doctorDetails.getName());
//                    binding.tvName.setText(doctorDetails.getName());
//                    binding.ivDoctorImage.setImageResource(doctorDetails.getDoctorImage());
//                    binding.tvSpecialty.setText(doctorDetails.getSpecialty());
//                    binding.rating.setRating(doctorDetails.getRate());
//                    binding.tvPatientsCount.setText(doctorDetails.getPatientsCont()+"");
//                    binding.tvExperienceYears.setText(doctorDetails.getExperienceYears()+" Years");
//                    binding.tvAboutUs.setText(doctorDetails.getAbout());
//
//                    //set the recycler of experience and workplaces
//                    ExperienceWorkplaceRvAdapter experienceAdapter = new ExperienceWorkplaceRvAdapter(doctorDetails.getExperienceList());
//                    ExperienceWorkplaceRvAdapter workplaceAdapter = new ExperienceWorkplaceRvAdapter(doctorDetails.getWorkplacesList());
//                    binding.rvExperience.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    binding.rvWorkPlace.setLayoutManager(new LinearLayoutManager(getActivity()));
//                    binding.rvExperience.setAdapter(experienceAdapter);
//                    binding.rvWorkPlace.setAdapter(workplaceAdapter);
//
//                }
//            });

        return binding.getRoot();
    }

}
