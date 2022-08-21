package com.suhail.clinicapp.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.FragmentBooking2Binding;

public class BookingFragment2 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBooking2Binding binding=FragmentBooking2Binding.inflate(getLayoutInflater());
        binding.btnMorning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnMorning.setBackgroundResource(R.drawable.shape_btn_clicked);
                binding.btnMorning.setTextColor(Color.parseColor("#FFFFFF"));
                binding.btnEvening.setBackgroundResource(R.drawable.shape_btn_unclicked);
                binding.btnEvening.setTextColor(Color.parseColor("#042D3B"));
                binding.cvEvening.setVisibility(View.GONE);
                binding.cvMorning.setVisibility(View.VISIBLE);
            }
        });
        binding.btnEvening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnEvening.setBackgroundResource(R.drawable.shape_btn_clicked);
                binding.btnEvening.setTextColor(Color.parseColor("#FFFFFF"));
                binding.btnMorning.setBackgroundResource(R.drawable.shape_btn_unclicked);
                binding.btnMorning.setTextColor(Color.parseColor("#042D3B"));
                binding.cvMorning.setVisibility(View.GONE);
                binding.cvEvening.setVisibility(View.VISIBLE);
            }
        });
        return binding.getRoot();
    }
}
