package com.suhail.clinicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.suhail.clinicapp.databinding.CustomclinicdoctorsBinding;

import java.util.List;

public class ClinicDrAdapter extends RecyclerView.Adapter<ClinicDrAdapter.DoctorsViewHolder> {

    CustomclinicdoctorsBinding binding ;
    Context context;
    List<Doctor> clinicdoctor ;

    public ClinicDrAdapter(Context context, List<Doctor> clinicdoctor) {
        this.context = context;
        this.clinicdoctor = clinicdoctor;
    }

    @NonNull
    @Override
    public DoctorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClinicDrAdapter.DoctorsViewHolder(CustomclinicdoctorsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsViewHolder holder, int position) {
    Doctor doctor = clinicdoctor.get(position);
    binding.tvDoctname.setText(doctor.getNameDoctor());
    binding.tvDocdetils.setText(doctor.getDetailsDoctor());
    }

    @Override
    public int getItemCount() {
        return clinicdoctor.size();
    }


    public class DoctorsViewHolder extends RecyclerView.ViewHolder{

        public DoctorsViewHolder(@NonNull CustomclinicdoctorsBinding itemView) {
            super(itemView.getRoot());
          binding=itemView;
        }
    }
}
