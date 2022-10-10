package com.suhail.clinicapp.models;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientDetails implements Serializable {
    private String name;
    private String age;
    private String doctor_name;
    private int  patient_img;
    private String appointmentDetails;
    private ArrayList<Treatment> treatmentList;


    public PatientDetails() {
    }

    public PatientDetails(String name, String age, String doctor_name, int patient_img, String appointmentDetails, ArrayList<Treatment> treatmentList) {
        this.name = name;
        this.age = age;
        this.doctor_name = doctor_name;
        this.patient_img = patient_img;
        this.appointmentDetails = appointmentDetails;
        this.treatmentList = treatmentList;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public int getPatient_img() {
        return patient_img;
    }

    public void setPatient_img(int patient_img) {
        this.patient_img = patient_img;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public ArrayList<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(ArrayList<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }
}
