package com.view;

public class Doctor {
    private String name;
    private String date;
    private boolean isAvailable; // True for available, false for unavailable

    public Doctor(String name, String date, boolean isAvailable) {
        this.name = name;
        this.date = date;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
