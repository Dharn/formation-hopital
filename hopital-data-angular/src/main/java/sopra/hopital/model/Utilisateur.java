package sopra.hopital.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Utilisateur {
	
	@Id
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	@Column(name = "version")
	private int version;
	
	@Column(name = "role")
	@JsonView(Views.Common.class)
	private String role;
	
	@Column(name = "login")
	@JsonView(Views.Common.class)
	private String login;
	
	@Column(name = "password")
	@JsonView(Views.Common.class)
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	

}
