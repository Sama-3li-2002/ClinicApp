package com.suhail.clinicapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.suhail.clinicapp.MainActivity;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.FragmentMapBinding;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity= (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMapBinding binding=FragmentMapBinding.inflate(getLayoutInflater());
        initMap();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navController.navigate(R.id.nav_departments);
            }
        });
        return binding.getRoot();
    }

    private void initMap() {
                   SupportMapFragment supportMapFragment=(SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map);
            supportMapFragment.getMapAsync(this);
        }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().title("hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_hospital_marker)).position(new LatLng(31.5000,34.4667)));
        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(31.5000,34.4667),12);
        googleMap.moveCamera(cameraUpdate);
    }
}
