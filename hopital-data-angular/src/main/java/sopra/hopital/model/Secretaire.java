package sopra.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name="sequenceSecretaire")
public class Secretaire {
	
	@Id @GeneratedValue(generator="sequenceSecretaire")
	@JsonView(Views.Common.class)
	private Long id;
	
	@JsonView(Views.Common.class)
	private String nom;
	
	@JsonView(Views.Common.class)
	private String prenom;
	
	@OneToOne
	@JoinColumn(name="utilisateur_id")
	@JsonView(Views.Common.class)
	
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "secretaire")
	//@JsonView(Views.Medecin.class)
	private List<Medecin> medecins;
	
	
	
	
	
	
	
	public Secretaire() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<Medecin> getMedecins() {
		return medecins;
	}
	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}
	
	

}
