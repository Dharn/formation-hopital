package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Disponibilite;
@Transactional
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long> {

}
