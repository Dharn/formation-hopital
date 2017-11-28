package sopra.hopital.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;




@Entity
public class Utilisateur {
	
	@Id
	
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	
	private int version;
	
	
	@JsonView(Views.Common.class)
	private Role role;
	
	
	@JsonView(Views.Common.class)
	private String login;
	
	
	@JsonView(Views.Common.class)
	private String motDePasse;
	
	//@JsonView(Views.Secretaire.class)
	private Medecin medecin;
	
	//@JsonView(Views.Medecin.class)
	private Secretaire secretaire;

	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String role, String login, String motDePasse) {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public Secretaire getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}
	
	
	
	
	
	

}
