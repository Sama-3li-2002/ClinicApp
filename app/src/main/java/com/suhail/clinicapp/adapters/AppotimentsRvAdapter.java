package com.suhail.clinicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suhail.clinicapp.databinding.CustomAppoitmentLayoutBinding;
import com.suhail.clinicapp.models.Appoitment;

import java.util.List;


public class AppotimentsRvAdapter extends RecyclerView.Adapter<AppotimentsRvAdapter.AppoitmentsViewHolder> {
    CustomAppoitmentLayoutBinding binding;
    Context context;
    List<Appoitment> appoitments;

    public AppotimentsRvAdapter(Context context, List<Appoitment> appoitments) {
        this.context = context;
        this.appoitments = appoitments;
    }

    @NonNull
    @Override
    public AppoitmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AppoitmentsViewHolder(CustomAppoitmentLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppoitmentsViewHolder holder, int position) {
        Appoitment appoitment = appoitments.get(position);
        binding.tvDateInt.setText(String.valueOf(appoitment.getDayInt()));
        binding.tvDay.setText(appoitment.getDay());
        binding.tvDate.setText(appoitment.getDate()+","+appoitment.getTime());
    }

    @Override
    public int getItemCount() {
        return appoitments.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class AppoitmentsViewHolder extends RecyclerView.ViewHolder{

        public AppoitmentsViewHolder(@NonNull CustomAppoitmentLayoutBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
