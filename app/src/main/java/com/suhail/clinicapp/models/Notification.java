package com.suhail.clinicapp.models;

public class Notification {
    private int dayInt;
    private String day;
    private String date;
    private String time;

    public Notification(int dayInt, String day, String date, String time) {
        this.dayInt = dayInt;
        this.day = day;
        this.date = date;
        this.time = time;
    }

    public int getDayInt() {
        return dayInt;
    }

    public void setDayInt(int dayInt) {
        this.dayInt = dayInt;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
