package com.project.back_end.services;

import com.project.back_end.entities.Appointment;
import com.project.back_end.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /* -------------------- CREATE -------------------- */

    /**
     * Saves a new appointment using the repository
     */
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    /* -------------------- READ -------------------- */

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    /* -------------------- UPDATE -------------------- */

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
                .map(existing -> {
                    existing.setDoctor(updatedAppointment.getDoctor());
                    existing.setPatient(updatedAppointment.getPatient());
                    existing.setAppointmentTime(updatedAppointment.getAppointmentTime());
                    existing.setStatus(updatedAppointment.getStatus());
                    return appointmentRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    /* -------------------- DELETE -------------------- */

    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
        appointmentRepository.deleteById(id);
    }
}
