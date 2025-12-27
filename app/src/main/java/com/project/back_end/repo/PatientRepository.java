package com.project.back_end.repo;

import com.project.back_end.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /* Find patient by associated user ID */
    Optional<Patient> findByUserId(Long userId);

    /* REQUIRED: Find patient by email */
    Optional<Patient> findByEmail(String email);
}
