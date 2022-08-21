package com.suhail.clinicapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.models.Department;

import java.util.List;

public class DepartmentsRvAdapter extends RecyclerView.Adapter<DepartmentsRvAdapter.DepartmentViewHolder> {
List<Department> departments;

    public DepartmentsRvAdapter(List<Department> departments) {
        this.departments = departments;
    }

    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_department_layout,parent,false);
        return new DepartmentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        holder.tv_name.setText(departments.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    class DepartmentViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        public DepartmentViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_department_name);
        }
    }
}
