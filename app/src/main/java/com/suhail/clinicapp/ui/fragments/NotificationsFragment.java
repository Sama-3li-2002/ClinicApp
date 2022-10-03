package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.adapters.NotificationsRvAdapter;
import com.suhail.clinicapp.databinding.FragmentNotificationsBinding;
import com.suhail.clinicapp.models.Appoitment;
import com.suhail.clinicapp.models.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentNotificationsBinding binding=FragmentNotificationsBinding.inflate(getLayoutInflater());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification(24,"wednesday","wed 24 Aug","1:30pm"));
        notifications.add(new Notification(24,"wednesday","wed 24 Aug","1:30pm"));
        notifications.add(new Notification(24,"wednesday","wed 24 Aug","1:30pm"));
        notifications.add(new Notification(24,"wednesday","wed 24 Aug","1:30pm"));
        notifications.add(new Notification(24,"wednesday","wed 24 Aug","1:30pm"));
        notifications.add(new Notification(24,"wednesday","wed 24 Aug","1:30pm"));
        notifications.add(new Notification(24,"wednesday","wed 24 Aug","1:30pm"));

        binding.rvNotifications.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvNotifications.setAdapter(new NotificationsRvAdapter(getActivity(),notifications));
        return binding.getRoot();

    }
}