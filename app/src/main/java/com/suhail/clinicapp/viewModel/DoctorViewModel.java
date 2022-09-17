package com.suhail.clinicapp.viewModel;

import android.media.Image;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.databinding.BindingAdapter;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.models.DoctorDetails;
import com.suhail.clinicapp.models.ExperienceWorkplace;

import java.util.ArrayList;

public class DoctorViewModel extends ViewModel {

    public static DoctorDetails details ;



    public MutableLiveData<DoctorDetails> mutableLiveData = new MutableLiveData<>();

// public void getDoctor(){
//     DoctorDetails doctor = getFromDatabase();
//     mutableLiveData.setValue(doctor);
// }
  public void getDoctorONeDetails(){
      DoctorDetails doctor1 = getFromDatabase();
      mutableLiveData.setValue(doctor1);
  }


    public DoctorDetails getFromDatabase(){
        DoctorDetails doctor1 = details;

//        doctor1.setName("Ahmed Mohammed");
//        doctor1.setSpecialty("Cardio");
//        doctor1.setDoctorImage(R.drawable.doctor);
        doctor1.setAbout("Excepteur sint occaecat cupidatat nonsit proident, \n" +
                "sunt in culpa qui officia deserunt mollit anim said  \n" +
                "eopksio laborum. sed ut perspiciatis unde oimnis \n" +
                "istpoe natus error sit voluptatem sit accusantium \n" +
                "doloremque eopsloi si laudantium,sit totam rem \n" +
                "aperiam, eaque ipsa quae ab inventore veritaie et \n" +
                "quasi architecto beatae vitaet ");
//        doctor1.setRate(3);
        doctor1.setPatientsCont(100);
        doctor1.setExperienceYears(5);

        ArrayList<ExperienceWorkplace> experienceList = new ArrayList<>();
        ArrayList<ExperienceWorkplace> workplacesList = new ArrayList<>();

        experienceList.add(new ExperienceWorkplace(R.drawable.bestdoctors_service,"It Started Working Since 1988"));
        experienceList.add(new ExperienceWorkplace(R.drawable.bestdoctors_service,"master"));
        experienceList.add(new ExperienceWorkplace(R.drawable.bestdoctors_service,"master"));

        workplacesList.add(new ExperienceWorkplace(R.drawable.clinic_profile,"Hclinic Clinic"));
        workplacesList.add(new ExperienceWorkplace(R.drawable.clinic_profile,"Hospital"));

        doctor1.setExperienceList(experienceList);
        doctor1.setWorkplacesList(workplacesList);


        return doctor1;
    }

    @BindingAdapter("android:setRate")
    public static void setRate(RatingBar ratingBar, float rate){
      ratingBar.setRating(rate);
    }

    @BindingAdapter("android:setImage")
    public static void setImage(ImageView imageView,int imageSrc){
      imageView.setImageResource(imageSrc);
    }
}
