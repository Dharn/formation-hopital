package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Secretaire;

@Transactional
public interface SecretaireRepository extends JpaRepository<Secretaire, Long>{

}
