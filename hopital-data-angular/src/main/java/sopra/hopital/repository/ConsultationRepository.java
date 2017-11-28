package sopra.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Consultation;

@Transactional
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
	@Query("select distinct c from Consultation c left join fetch c.patient p")
	List<Consultation> findAllWithPatient();
}
