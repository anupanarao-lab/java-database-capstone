package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    // Temporary in-memory list (replace with Repository later)
    private List<Appointment> appointmentList = new ArrayList<>();

    // Create appointment
    public String createAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        return "Appointment created successfully";
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentList;
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int id) {
        return appointmentList.stream()
                .filter(app -> app.getAppointmentId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update appointment status
    public String updateAppointmentStatus(int id, String status) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentId() == id) {
                appointment.setStatus(status);
                return "Appointment updated successfully";
            }
        }
        return "Appointment not found";
    }

    // Delete appointment
    public String deleteAppointment(int id) {
        boolean removed = appointmentList.removeIf(app -> app.getAppointmentId() == id);
        return removed ? "Appointment deleted successfully" : "Appointment not found";
    }
}
