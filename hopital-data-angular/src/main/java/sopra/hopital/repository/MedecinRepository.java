package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.hopital.model.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}
