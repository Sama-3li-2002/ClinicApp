package com.suhail.clinicapp.models;

import java.io.Serializable;


public class Patient extends PatientDetails  implements Serializable {

    private String name;
    private String age;
    private String doctor_name;
    private int  patient_img;

    public Patient(String name, String age, String doctor_name , int patient_img) {
        this.name = name;
        this.age = age;
        this.doctor_name = doctor_name;
        this.patient_img = patient_img;
    }

    public Patient() {
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
}