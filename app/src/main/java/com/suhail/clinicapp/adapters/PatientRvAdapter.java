package com.suhail.clinicapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.suhail.clinicapp.databinding.CustomPatientListBinding;
import com.suhail.clinicapp.listeners.OnPatientSelectedListener;
import com.suhail.clinicapp.models.Patient;
import java.util.List;

public class PatientRvAdapter extends RecyclerView.Adapter<PatientRvAdapter.PatientViewHolder> {
    Context context;
     CustomPatientListBinding binding;
    List<Patient> patientDetails;
    OnPatientSelectedListener listener;

    public PatientRvAdapter(Context context, List<Patient> patientDetails, OnPatientSelectedListener listener) {
        this.context = context;
        this.patientDetails = patientDetails;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new PatientViewHolder(CustomPatientListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, @SuppressLint("RecyclerView") int position) {

        binding.setData(patientDetails.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPatientSelected(patientDetails.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return patientDetails.size();
    }



    public class PatientViewHolder extends RecyclerView.ViewHolder{
        public PatientViewHolder(@NonNull CustomPatientListBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}