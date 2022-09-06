package com.suhail.clinicapp.adapters;

public class Doctor {
    private String nameDoctor;
    private String detailsDoctor;

    public Doctor(String nameDoctor, String detailsDoctor) {
        this.nameDoctor = nameDoctor;
        this.detailsDoctor = detailsDoctor;
    }

    public Doctor() {

    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getDetailsDoctor() {
        return detailsDoctor;
    }

    public void setDetailsDoctor(String detailsDoctor) {
        this.detailsDoctor = detailsDoctor;
    }
}
