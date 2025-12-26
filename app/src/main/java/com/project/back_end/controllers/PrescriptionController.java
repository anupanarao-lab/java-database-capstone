package com.project.back_end.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // Temporary in-memory storage
    private List<String> prescriptions = new ArrayList<>();

    // Add prescription
    @PostMapping("/add")
    public String addPrescription(@RequestBody String prescription) {
        prescriptions.add(prescription);
        return "Prescription added successfully";
    }

    // Get all prescriptions
    @GetMapping("/all")
    public List<String> getAllPrescriptions() {
        return prescriptions;
    }

    // Delete prescription
    @DeleteMapping("/delete/{index}")
    public String deletePrescription(@PathVariable int index) {
        if (index >= 0 && index < prescriptions.size()) {
            prescriptions.remove(index);
            return "Prescription deleted successfully";
        }
        return "Prescription not found";
    }
}
