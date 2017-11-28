package sopra.hopital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;


@Entity
@Table(name = "medecin_specialite", uniqueConstraints = @UniqueConstraint(columnNames = { "medecin_id", "specialite_id" }))
@SequenceGenerator(name="sequenceMedecinSpecialite")
public class MedecinSpecialite {
	@Id @GeneratedValue(generator="sequenceMedecinSpecialite")
	@Column(name="id")
	private Long id;
	
	@Version
	@Column(name="version")
	private int version;
	
	@ManyToOne
	@JoinColumn(name = "medecin_id")
	private Medecin medecin;
	
	@ManyToOne
	@JoinColumn(name = "specialite_id")
	private Specialite specialite;
	
	@Column(name="tarif")
	private Double tarif;
	
	@Column(name="duree")
	private Integer duree;
	
	public MedecinSpecialite(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	
	
	
	
}
