package sopra.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Disponibilite;
@Transactional
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long> {
	
	@Query("select d from Disponibilite d left join fetch d.medecin m where m.id = :id")
	List<Disponibilite> listDispoByMedecin(@Param("id") Long id);

}
