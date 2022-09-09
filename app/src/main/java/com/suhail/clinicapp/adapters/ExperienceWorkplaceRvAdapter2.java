package com.suhail.clinicapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.databinding.CustomExperienceWorkplaceLayoutBinding;
import com.suhail.clinicapp.models.ExperienceWorkplace;

import java.util.ArrayList;

public class ExperienceWorkplaceRvAdapter2 extends RecyclerView.Adapter<ExperienceWorkplaceRvAdapter2.ExperienceWorkplaceViewHolder> {
ArrayList<ExperienceWorkplace> list;

    public ExperienceWorkplaceRvAdapter2(ArrayList<ExperienceWorkplace> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ExperienceWorkplaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExperienceWorkplaceViewHolder(CustomExperienceWorkplaceLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienceWorkplaceViewHolder holder, int position) {
        holder.binding.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ExperienceWorkplaceViewHolder extends RecyclerView.ViewHolder{
        CustomExperienceWorkplaceLayoutBinding binding;
        public ExperienceWorkplaceViewHolder(@NonNull CustomExperienceWorkplaceLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
