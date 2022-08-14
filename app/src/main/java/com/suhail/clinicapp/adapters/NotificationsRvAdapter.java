package com.suhail.clinicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suhail.clinicapp.databinding.CustomNotificationLayoutBinding;
import com.suhail.clinicapp.models.Notification;

import java.util.List;

public class NotificationsRvAdapter extends RecyclerView.Adapter<NotificationsRvAdapter.NotificationsViewHolder> {
    CustomNotificationLayoutBinding binding;
    Context context;
    List<Notification> notifications;

    public NotificationsRvAdapter(Context context, List<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public NotificationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationsViewHolder(CustomNotificationLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsViewHolder holder, int position) {
        Notification notification=notifications.get(position);
        binding.tvDateInt.setText(String.valueOf(notification.getDayInt()));
        binding.tvDay.setText(notification.getDay());
        binding.tvDate.setText(notification.getDate()+","+notification.getTime());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }


    public class NotificationsViewHolder extends RecyclerView.ViewHolder{

        public NotificationsViewHolder(@NonNull CustomNotificationLayoutBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
