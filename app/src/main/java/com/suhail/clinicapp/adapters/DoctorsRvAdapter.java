package com.suhail.clinicapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.suhail.clinicapp.databinding.CustomDoctorLayoutBinding;
import com.suhail.clinicapp.listeners.OnDoctorSelectedListener;
import com.suhail.clinicapp.models.DoctorDetails;
import com.suhail.clinicapp.viewModel.CustomDoctorLayoutViewModel;
import com.suhail.clinicapp.viewModel.DoctorViewModel;

import java.util.List;

public class DoctorsRvAdapter extends RecyclerView.Adapter<DoctorsRvAdapter.DoctorsViewHolder> {

    CustomDoctorLayoutBinding binding;
    Context context;
    List<CustomDoctorLayoutViewModel> list;
    OnDoctorSelectedListener listener;

    public DoctorsRvAdapter(Context context,List<CustomDoctorLayoutViewModel> list, OnDoctorSelectedListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DoctorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DoctorsRvAdapter.DoctorsViewHolder(CustomDoctorLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsViewHolder holder, @SuppressLint("RecyclerView") int position) {
    binding.setData(list.get(position));
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listener.onDoctorSelected(list.get(position).getFromDatabase());
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class DoctorsViewHolder extends RecyclerView.ViewHolder{

        public DoctorsViewHolder(@NonNull CustomDoctorLayoutBinding itemView) {
            super(itemView.getRoot());
          binding=itemView;
        }
    }
}
