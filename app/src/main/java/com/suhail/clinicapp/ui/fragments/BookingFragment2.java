package com.suhail.clinicapp.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.FragmentBooking2Binding;
import com.suhail.clinicapp.databinding.TestBinding;
import com.suhail.clinicapp.listeners.OnClinicClickedListener;

import java.util.Date;

public class BookingFragment2 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBooking2Binding binding = FragmentBooking2Binding.inflate(getLayoutInflater());


        //handle button morning click event
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

        //handle button evening click event
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

        //assign AM buttons clicklistener
        binding.btnTimeAm1.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimeAm2.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimeAm3.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimeAm4.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimeAm5.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimeAm6.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimeAm7.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimeAm8.setOnClickListener(btnTimeOnClickListener);

        //assign PM buttons clicklistener
        binding.btnTimePm1.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimePm2.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimePm3.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimePm4.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimePm5.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimePm6.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimePm7.setOnClickListener(btnTimeOnClickListener);
        binding.btnTimePm8.setOnClickListener(btnTimeOnClickListener);

        //handle button save click event
        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long date = binding.calendar.getDate();
            }
        });

        return binding.getRoot();
    }

    //define a clickListener to handle time buttons
    View.OnClickListener btnTimeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            Toast.makeText(getActivity(), btn.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    };
}
