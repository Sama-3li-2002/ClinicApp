package com.suhail.clinicapp.models;

import java.io.Serializable;
import java.util.ArrayList;

public class DoctorDetails implements Serializable {

    String name;
    String specialty;
    float rate;
    int patientsCont;
    int experienceYears;
    int doctorImage;
    String about;
    ArrayList<ExperienceWorkplace> experienceList;
    ArrayList<ExperienceWorkplace> workplacesList;

    public DoctorDetails() {
    }

    public DoctorDetails(String name, String specialty, float rate, int patientsCont, int experienceYears, int doctorImage, String about, ArrayList<ExperienceWorkplace> experienceList, ArrayList<ExperienceWorkplace> workplacesList) {
        this.name = name;
        this.specialty = specialty;
        this.rate = rate;
        this.patientsCont = patientsCont;
        this.experienceYears = experienceYears;
        this.doctorImage = doctorImage;
        this.about = about;
        this.experienceList = experienceList;
        this.workplacesList = workplacesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getPatientsCont() {
        return patientsCont;
    }

    public void setPatientsCont(int patientsCont) {
        this.patientsCont = patientsCont;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(int doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public ArrayList<ExperienceWorkplace> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<ExperienceWorkplace> experienceList) {
        this.experienceList = experienceList;
    }

    public ArrayList<ExperienceWorkplace> getWorkplacesList() {
        return workplacesList;
    }

    public void setWorkplacesList(ArrayList<ExperienceWorkplace> workplacesList) {
        this.workplacesList = workplacesList;
    }
}
