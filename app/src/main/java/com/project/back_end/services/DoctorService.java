package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    // Temporary in-memory storage (can be replaced with Repository)
    private List<Doctor> doctorList = new ArrayList<>();

    // Add doctor
    public String addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        return "Doctor added successfully";
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    //
