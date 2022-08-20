package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.suhail.clinicapp.R;

public class BookingFragment extends Fragment implements  View.OnClickListener{
Button btn1, btn2;
    Button bt1, bt2,bt3,bt4,bt5,bt6,bt7;



    public BookingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        btn1 =view.findViewById(R.id.bv_evning);
        btn2 =view.findViewById(R.id.bv_morning);
        bt1=view.findViewById(R.id.bv_1);
        bt2=view.findViewById(R.id.bv_2);
        bt3=view.findViewById(R.id.bv_3);
        bt4=view.findViewById(R.id.bv_4);
        bt5=view.findViewById(R.id.bv_5);
        bt6=view.findViewById(R.id.bv_6);
        bt7=view.findViewById(R.id.bv_7);
        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bv_evning:
                bt1.setText("1:00PM");
                bt2.setText("1:30PM");
                bt3.setText("2:00PM");
                bt4.setText("2:30PM");
                bt5.setText("2:00PM");
                bt6.setText("2:30PM");
                bt7.setText("3:0PM");
                break;

            case R.id.bv_morning:
                bt1.setText("8:30AM");
                bt2.setText("9:0AM");
                bt3.setText("9:30AM");
                bt4.setText("10:00AM");
                bt5.setText("10:30AM");
                bt6.setText("11:00AM");
                bt7.setText("11:30AM");
                break;
      }


    }
}