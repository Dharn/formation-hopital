package sopra.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Entity
@SequenceGenerator(name="sequenceMedecin")
public class Medecin {
	@Id @GeneratedValue(generator="sequenceMedecinSpecialite")
	@Column(name="id")
	private Integer id;
	
	@Version
	@Column(name="version")
	private int version;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="convention")
	private Convention convention;
	
	@Column(name="carte_vitale")
	private Boolean carteVitale;
	
	@Column(name="cmu")
	private Boolean cmu;
	
	
	private Secretaire secretaire;
	
	private Utilisateur utilisateur;
	
	private List<Disponibilite> listeDisponibilites;
	
	private List<Consultation> listeConsultations;
	
	private List<MedecinSpecialite>
	
	public Medecin(){
		
	}
}
