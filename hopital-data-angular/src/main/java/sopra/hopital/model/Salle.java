package sopra.hopital.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="seqSalle")
@Table(name = "salle")
public class Salle {  
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqSalle")
	@Id
<<<<<<< HEAD
	@JsonView(Views.Salle.class)
=======
>>>>>>> 482a05b909fa01a4ac3d33df73d6fbf8affb4a24
	private Long id;
	
	@Version
	private int version;

<<<<<<< HEAD
	@JsonView(Views.Salle.class)
	private String numero;
	
	@OneToMany(mappedBy = "specialite")
//	@JsonView(Views.Salle.class)
=======
	private String numero;
	
	@OneToMany(mappedBy = "specialite")
>>>>>>> 482a05b909fa01a4ac3d33df73d6fbf8affb4a24
	private List<SalleSpecialite> salleSpecialites;

	@OneToMany(mappedBy = "salle")
	private List<Consultation> consultations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<SalleSpecialite> getSalleSpecialites() {
		return salleSpecialites;
	}

	public void setSalleSpecialites(List<SalleSpecialite> salleSpecialites) {
		this.salleSpecialites = salleSpecialites;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	
	

	
}
