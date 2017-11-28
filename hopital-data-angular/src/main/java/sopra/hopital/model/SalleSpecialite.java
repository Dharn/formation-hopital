package sopra.hopital.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "salle_specialite",  uniqueConstraints = @UniqueConstraint(columnNames = { "salle_id", "specialite_id" }))
@SequenceGenerator(name="seqSalleSpecialite")
public class SalleSpecialite {

	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "specialite_id")
	private Specialite specialite;
	
	@ManyToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
}
