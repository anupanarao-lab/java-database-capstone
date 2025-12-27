package com.project.back_end.services;

import com.project.back_end.entities.Doctor;
import com.project.back_end.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /* -------------------- CRUD -------------------- */

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedDoctor.getName());
                    existing.setSpecialization(updatedDoctor.getSpecialization());
                    existing.setPhone(updatedDoctor.getPhone());
                    existing.setAvailableTimes(updatedDoctor.getAvailableTimes());
                    return doctorRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }

    /* -------------------- REQUIRED FUNCTIONALITY -------------------- */

    /**
     * Retrieve doctor's available time slots for a specific date
     */
    public List<String> getAvailabilityByDoctorAndDate(Long doctorId, LocalDate date) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));

        // In a real system, availability would be date-specific
        // This assumes availableTim
