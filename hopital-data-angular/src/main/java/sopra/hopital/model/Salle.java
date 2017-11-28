package sopra.hopital.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Long id;
	
	@Version
	private int version;

	private String numero;
	
	@OneToMany
	private List<SalleSpecialite> salleSpecialites;
	
	@ManyToOne
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
	

	
}
