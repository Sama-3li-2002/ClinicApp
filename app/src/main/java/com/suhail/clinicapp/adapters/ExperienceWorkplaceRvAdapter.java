package com.suhail.clinicapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.models.ExperienceWorkplace;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ExperienceWorkplaceRvAdapter extends RecyclerView.Adapter<ExperienceWorkplaceRvAdapter.ExperienceWorkplaceViewHolder> {
ArrayList<ExperienceWorkplace> list = new ArrayList<>();

    public ExperienceWorkplaceRvAdapter(ArrayList<ExperienceWorkplace> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ExperienceWorkplaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExperienceWorkplaceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_experience_workplace_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienceWorkplaceViewHolder holder, int position) {
        holder.iv_image.setImageResource(list.get(position).getImage());
        holder.tv_text.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ExperienceWorkplaceViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_image;
        TextView tv_text;
        public ExperienceWorkplaceViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image=itemView.findViewById(R.id.iv_image);
            tv_text=itemView.findViewById(R.id.tv_text);
        }
    }
}
