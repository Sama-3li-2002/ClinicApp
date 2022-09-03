package com.suhail.clinicapp.models;

import java.io.Serializable;

public class ClinicService implements Serializable {
    private  int image;
    private  String serviceName;

    public ClinicService(int image, String serviceName) {
        this.image = image;
        this.serviceName = serviceName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
