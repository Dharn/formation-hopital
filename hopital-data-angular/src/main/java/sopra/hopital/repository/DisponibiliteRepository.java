package sopra.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.hopital.model.Disponibilite;
@Transactional
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long> {
	@Query("select d from Disponibilite d left join fetch d.medecin m where m.id = :id")
	List<Disponibilite> listDispoByMedecin(@Param("id") Long id);
}
