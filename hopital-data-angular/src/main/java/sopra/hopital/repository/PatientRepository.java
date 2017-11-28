package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.hopital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}
