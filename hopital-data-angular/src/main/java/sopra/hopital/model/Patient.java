package sopra.hopital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqPatient")
@Table(name = "patient")
public class Patient {  
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPatient")
	@Id
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private String codePostal;
	
	private String ville;

	private String pays;

	private String courriel;

	private String telephone;

	private String securiteSociale;

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
	
	
	
	
}
