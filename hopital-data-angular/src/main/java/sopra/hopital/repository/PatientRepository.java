package sopra.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import sopra.hopital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	@Query("from Patient p where p.nom = :nom")
	List<Patient> findAllByNom(String nom);

}
