package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Utilisateur;

@Transactional
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
