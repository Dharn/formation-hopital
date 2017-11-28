package sopra.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sopra.hopital.model.Consultation;
import sopra.hopital.model.Medecin;
import sopra.hopital.model.MedecinSpecialite;

@Transactional
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	@Query("select from Medecin m left join fetch MedecinSpecialite ms where m.id = :id")
	public List<MedecinSpecialite> findAllTarifEtDuree(@Param("id") Long id);
	
	@Query("select from Medecin m left join fetch MedecinSpecialite ms where m.id = :idMedecin and s.id = :idSpecialite")
	public MedecinSpecialite findTarifEtDuree(@Param("idMedecin") Long idMedecin, @Param("idSpecialite") Integer idSpecialite);
//	
//	@Query("select from Medecin m left join fetch Consultation c where m.id = :id")
//	public List<Consultation> findAllConsultation(@Param("id") Long id);
	
//	@Query("select from Medecin m left join fetch Consultation c where m.id = :idMedecin and ")
//	public List<Consultation> findAllConsultation(@Param("idMedecin") Long idMedecin, @Param("idSpecialite") Integer idSpecialite);
}
