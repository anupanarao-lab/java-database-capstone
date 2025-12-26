package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    // Temporary in-memory list (can be replaced with Service + Repository)
    private List<Doctor> doctorList = new ArrayList<>();

    // Add a new doctor
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor) {
        doctorList.add(doctor);
        return "Doctor added successfully";
    }

    // Get all doctors
    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorList.stream()
                .filter(doc -> doc.getDoctorId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update doctor details
    @PutMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id, @RequestBody Doctor updatedDoctor) {
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId() == id) {
                doctor.setName(updatedDoctor.getName());
                doctor.setSpecialization(updatedDoctor.getSpecialization());
                doctor.setPhone(updatedDoctor.getPhone());
                return "Doctor updated successfully";
            }
        }
        return "Doctor not found";
    }

    // Delete doctor
    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorList.removeIf(doc -> doc.getDoctorId() == id);
        return "Doctor deleted successfully";
    }
}
