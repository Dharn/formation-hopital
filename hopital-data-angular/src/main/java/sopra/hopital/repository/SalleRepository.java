package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Salle;

@Transactional
public interface SalleRepository extends JpaRepository<Salle, Long>{

}
