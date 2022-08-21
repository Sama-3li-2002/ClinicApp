package com.suhail.clinicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.CustomClinicItemLayoutBinding;
import com.suhail.clinicapp.listeners.OnClinicClickedListener;
import com.suhail.clinicapp.models.Clinic;

import java.util.List;

public class ClinicRvAdapter extends RecyclerView.Adapter<ClinicRvAdapter.ClinicViewHolder> {
    CustomClinicItemLayoutBinding binding;
    Context context;
    List<Clinic> clinics;
    OnClinicClickedListener listener;

    public ClinicRvAdapter(Context context, List<Clinic> clinics,OnClinicClickedListener listener) {
        this.context = context;
        this.clinics = clinics;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ClinicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClinicViewHolder(CustomClinicItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClinicViewHolder holder, int position) {
        Clinic clinic=clinics.get(position);
        binding.cvClinic.setBackgroundResource(R.drawable.custom_clinic_image_shape);
        binding.ivClinicImage.setImageResource(clinic.getImage());
        binding.tvClinicName.setText(clinic.getName());
        binding.tvClincAddress.setText(clinic.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClinicClicked(clinic.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return clinics.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ClinicViewHolder extends RecyclerView.ViewHolder{

        public ClinicViewHolder(@NonNull CustomClinicItemLayoutBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
