package com.suhail.clinicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.suhail.clinicapp.databinding.CustomServiceLayoutBinding;
import com.suhail.clinicapp.models.ClinicService;

import java.util.List;

public class ClinicPagerAdapter extends RecyclerView.Adapter<ClinicPagerAdapter.ClinicPagerViewHolder> {
    CustomServiceLayoutBinding binding;
    private Context context;
    private List<ClinicService> clinicService;
    private ViewPager2 viewPager2;


    public ClinicPagerAdapter(Context context, List<ClinicService> clinicService, ViewPager2 viewPager2) {
        this.context = context;
        this.clinicService = clinicService;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ClinicPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClinicPagerViewHolder(CustomServiceLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClinicPagerViewHolder holder, int position) {
        ClinicService clinicPager = clinicService.get(position);
        binding.ivServiceImage.setImageResource(clinicPager.getImage());
        binding.tvServiceName.setText(clinicPager.getServiceName());

    }

    @Override
    public int getItemCount() {
        return clinicService.size();
    }


    public class ClinicPagerViewHolder extends RecyclerView.ViewHolder {

        public ClinicPagerViewHolder(@NonNull CustomServiceLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
