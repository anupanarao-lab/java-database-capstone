package com.project.back_end.models;

public class Doctor {

    private int doctorId;
    private int userId;
    private String name;
    private String specialization;
    private String phone;

    // No-argument constructor
    public Doctor() {
    }

    // Parameterized constructor
    public Doctor(int doctorId, int userId, String name, String specialization, String phone) {
        this.doctorId = doctorId;
        this.userId = userId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
