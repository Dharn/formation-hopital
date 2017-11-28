package sopra.hopital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Entity
@Table(name = "medecin_specialite", uniqueConstraints = @UniqueConstraint(columnNames = { "medecin_id", "specialite_id" }))
public class MedecinSpecialite {
	
	@Id @GeneratedValue
	private Long id;
	
	@Version
	private int version;
}
