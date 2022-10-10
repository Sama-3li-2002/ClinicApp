package com.suhail.clinicapp.viewModel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.suhail.clinicapp.R;
import com.suhail.clinicapp.models.Patient;

import java.util.ArrayList;

public class CustomPatientListViewModel extends ViewModel {

    public MutableLiveData<ArrayList<Patient>>mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Patient>>getPateint(){
        ArrayList<Patient> doctor1 = getFromDatabase();
        mutableLiveData.setValue(doctor1);
        return mutableLiveData;
    }

    public ArrayList<Patient> getFromDatabase(){
        ArrayList<Patient> arrayList = new ArrayList<>();
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed", R.drawable.patient_img));
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed",R.drawable.patient_img));
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed",R.drawable.patient_img));
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed",R.drawable.patient_img));
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed",R.drawable.patient_img));
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed",R.drawable.patient_img));
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed",R.drawable.patient_img));
        arrayList.add(new Patient("Ahmed Mohammed", "20 Years","Dr.Mohammed",R.drawable.patient_img));
        return arrayList;
    }

    @BindingAdapter("android:setImage")
    public static void setImage(ImageView imageView, int imageSrc){
        imageView.setImageResource(imageSrc);
    }


}