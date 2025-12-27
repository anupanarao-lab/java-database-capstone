package com.project.back_end.controllers;

import com.project.back_end.entities.Prescription;
import com.project.back_end.services.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    /* -------------------- CREATE -------------------- */

    /**
     * Create a new prescription with validation
     */
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(
            @Valid @RequestBody Prescription prescription) {

        Prescription savedPrescription =
                prescriptionService.createPrescription(prescription);

        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }

    /* -------------------- READ -------------------- */

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionService.getAllPrescriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* -------------------- DELETE -------------------- */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }
}
