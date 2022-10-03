package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.AppotimentsRvAdapter;
import com.suhail.clinicapp.databinding.FragmentAppoitmentsBinding;
import com.suhail.clinicapp.models.Appoitment;

import java.util.ArrayList;
import java.util.List;


public class AppoitmentsFragment extends Fragment {


    public AppoitmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAppoitmentsBinding binding=FragmentAppoitmentsBinding.inflate(getLayoutInflater());



        List<Appoitment> appoitments=new ArrayList<>();
        appoitments.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));
        appoitments.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));
        appoitments.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));
        appoitments.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));
        appoitments.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));
        appoitments.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));
        appoitments.add(new Appoitment(24,"wednesday","wed 24 Aug","1:30pm"));

        AppotimentsRvAdapter adapter=new AppotimentsRvAdapter(getActivity(),appoitments);
        binding.rvAppoitments.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvAppoitments.setAdapter(adapter);
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_appoitments, container, false);
    }
}