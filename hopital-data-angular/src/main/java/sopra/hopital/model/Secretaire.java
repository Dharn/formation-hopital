package sopra.hopital.model;

import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Secretaire {
	
	@JsonView(Views.Common.class)
	private String nom;
	
	@JsonView(Views.Common.class)
	private String prenom;
		
	@JsonView(Views.Common.class)
	private Utilisateur utilisateur;
	
	//@JsonView(Views.Medecin.class)
	private List<Medecin> medecins;

}
