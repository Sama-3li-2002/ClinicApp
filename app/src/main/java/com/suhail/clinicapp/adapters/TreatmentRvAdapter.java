package com.suhail.clinicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.suhail.clinicapp.databinding.CustomTreatmentLayoutBinding;
import com.suhail.clinicapp.models.Treatment;

import java.util.List;

public class TreatmentRvAdapter extends RecyclerView.Adapter<TreatmentRvAdapter.MedicalDiagnosisViewHolder> {

    CustomTreatmentLayoutBinding binding;
    Context context;
    List<Treatment> list;

    public TreatmentRvAdapter(Context context, List<Treatment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TreatmentRvAdapter.MedicalDiagnosisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MedicalDiagnosisViewHolder(CustomTreatmentLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull TreatmentRvAdapter.MedicalDiagnosisViewHolder holder, int position) {
        binding.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class MedicalDiagnosisViewHolder extends RecyclerView.ViewHolder{

        public MedicalDiagnosisViewHolder(@NonNull CustomTreatmentLayoutBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}