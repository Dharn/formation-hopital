package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.hopital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
