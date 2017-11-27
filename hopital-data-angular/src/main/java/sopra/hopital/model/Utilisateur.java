package sopra.hopital.model;

import javax.persistence.Entity;

@Entity
public class Utilisateur {
	
	private Long id;
	
	private String role;
	
	private String login;
	
	private String motDePasse;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
	
	

}
