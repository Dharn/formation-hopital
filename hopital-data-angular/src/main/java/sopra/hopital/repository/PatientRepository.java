package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.hopital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	@Query("select p from Patient p left join fetch p.consultations c where p.id = :id")
	Patient findOnePatientWithConsultations(@Param("id") Long id);
	
}
