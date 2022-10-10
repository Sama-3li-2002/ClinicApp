package com.suhail.clinicapp.viewModel;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.suhail.clinicapp.R;
import com.suhail.clinicapp.models.PatientDetails;
import com.suhail.clinicapp.models.Treatment;

import java.util.ArrayList;

public class MedicalDiagnosisViewModel extends ViewModel {
    private MutableLiveData<PatientDetails>mutable = new MutableLiveData<>();
    public static PatientDetails patientDetails;

   public MutableLiveData<PatientDetails> getPatientOneDetails(){
       PatientDetails patientDetails = getFromDatabase();
       mutable.setValue(patientDetails);
       return mutable;
   }
    public PatientDetails getFromDatabase (){
         PatientDetails patientOne = patientDetails;
        patientOne.setAppointmentDetails("Excepteur sint occaecat cupidatat nonsit proident, \n" +
                "sunt in culpa qui officia deserunt mollit anim said  \n" +
                "eopksio laborum. sed ut perspiciatis unde oimnis \n" +
                "istpoe natus error sit voluptatem sit accusantium \n" +
                "doloremque eopsloi si laudantium,sit totam rem \n" +
                "aperiam, eaque ipsa quae ab inventore veritaie et \n" +
                "quasi architecto beatae vitaet ");

        ArrayList<Treatment> treatmentList = new ArrayList<>();

        treatmentList.add(new Treatment( R.drawable.treatment,"omeprazole"));
        treatmentList.add(new Treatment( R.drawable.treatment,"omeprazole"));
        patientOne.setTreatmentList(treatmentList);
        return  patientOne;

    }
    @BindingAdapter("android:setImage")
    public static void setImage(ImageView imageView, int imageSrc){
        imageView.setImageResource(imageSrc);
    }
}
