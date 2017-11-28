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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name="seqPatient")
@Table(name = "patient")
public class Patient {  
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPatient")
	@Id
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	private int version;
	
	@JsonView(Views.Common.class)
	private String nom;
	
	@JsonView(Views.Common.class)
	private String prenom;
	
	@JsonView(Views.Common.class)
	private String rue;
	
	@JsonView(Views.Common.class)
	private String codePostal;
	
	@JsonView(Views.Common.class)
	private String ville;

	@JsonView(Views.Common.class)
	private String pays;

	@JsonView(Views.Common.class)
	private String courriel;

	@JsonView(Views.Common.class)
	private String telephone;

	@JsonView(Views.Common.class)
	private String securiteSociale;
	
	@JsonView({Views.Patient.class, Views.Consultation.class})
	@OneToMany (mappedBy = "patient")
	private List<Consultation> consultations;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSecuriteSociale() {
		return securiteSociale;
	}

	public void setSecuriteSociale(String securiteSociale) {
		this.securiteSociale = securiteSociale;
	}
	
	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}


	
	
	
}
