package com.suhail.clinicapp.viewModel;

import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.models.DoctorDetails;

public class CustomDoctorLayoutViewModel extends ViewModel {

    public MutableLiveData<DoctorDetails> mutableLiveData = new MutableLiveData<>();


    public void getDoctors(){
        DoctorDetails doctor1 = getFromDatabase();
        mutableLiveData.setValue(doctor1);
    }



    public DoctorDetails getFromDatabase(){
        DoctorDetails doctor1 = new DoctorDetails();
        doctor1.setName("Ahmed Mohammed");
        doctor1.setSpecialty("Cardio");
        doctor1.setDoctorImage(R.drawable.doctor);
        doctor1.setRate(3);

        return doctor1;
    }

    @BindingAdapter("android:setRate")
    public static void setRate(RatingBar ratingBar, float rate){
        ratingBar.setRating(rate);
    }

    @BindingAdapter("android:setImage")
    public static void setImage(ImageView imageView, int imageSrc){
        imageView.setImageResource(imageSrc);
    }
}


