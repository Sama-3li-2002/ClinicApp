package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.ClinicRvAdapter;
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

        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
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


        //test for doctor details fragment
        DoctorDetails doctor1 = new DoctorDetails();
        doctor1.setName("Ahmed Mohammed");
        doctor1.setSpecialty("Cardio");
        doctor1.setDoctorImage(R.drawable.doctor);
        doctor1.setAbout("Excepteur sint occaecat cupidatat nonsit proident, \n" +
                "sunt in culpa qui officia deserunt mollit anim said  \n" +
                "eopksio laborum. sed ut perspiciatis unde oimnis \n" +
                "istpoe natus error sit voluptatem sit accusantium \n" +
                "doloremque eopsloi si laudantium,sit totam rem \n" +
                "aperiam, eaque ipsa quae ab inventore veritaie et \n" +
                "quasi architecto beatae vitaet ");
        doctor1.setRate(3);
        doctor1.setPatientsCont(100);
        doctor1.setExperienceYears(5);

        ArrayList<ExperienceWorkplace> experienceList = new ArrayList<>();
        ArrayList<ExperienceWorkplace> workplacesList = new ArrayList<>();

        experienceList.add(new ExperienceWorkplace(R.drawable.bestdoctors_service,"It Started Working Since 1988"));
        experienceList.add(new ExperienceWorkplace(R.drawable.bestdoctors_service,"master"));
        experienceList.add(new ExperienceWorkplace(R.drawable.bestdoctors_service,"master"));

        workplacesList.add(new ExperienceWorkplace(R.drawable.clinic_profile,"Hclinic Clinic"));
        workplacesList.add(new ExperienceWorkplace(R.drawable.clinic_profile,"Hospital"));

        doctor1.setExperienceList(experienceList);
        doctor1.setWorkplacesList(workplacesList);

        Bundle bundle = new Bundle();
        bundle.putSerializable("data",doctor1);
        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_doctor_details,bundle);
            }
        });

         return binding.getRoot();
    }
}