package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Consultation;

@Transactional
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

}
