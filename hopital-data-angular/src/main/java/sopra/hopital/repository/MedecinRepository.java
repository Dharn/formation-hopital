package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Medecin;

@Transactional
public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
