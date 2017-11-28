package sopra.hopital.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Secretaire {
	
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

}
