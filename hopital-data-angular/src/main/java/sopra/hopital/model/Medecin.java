package sopra.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name="sequenceMedecin")
public class Medecin {
	
	
	@Id @GeneratedValue(generator="sequenceMedecin")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Version
	@Column(name="version")
	private int version;
	

	@Column(name="nom")
	@JsonView(Views.Common.class)
	private String nom;
	
	@Column(name="prenom")
	@JsonView(Views.Common.class)
	private String prenom;
	
	@Column(name="convention")
	@JsonView(Views.Common.class)
	private Convention convention;
	
	@Column(name="carte_vitale")
	@JsonView(Views.Common.class)
	private Boolean carteVitale;
	
	@Column(name="cmu")
	@JsonView(Views.Common.class)
	private Boolean cmu;
	
	@ManyToOne
	@JoinColumn(name = "medecin_id")
	@JsonView(Views.Common.class)
	private Secretaire secretaire;
	
	@OneToOne
	@JoinColumn(name="utilisateur_id")
	@JsonView(Views.Common.class)
	private Utilisateur utilisateur;
	
	
	@OneToMany(mappedBy = "medecin")
	@JsonView({Views.Medecin.class, Views.Secretaire.class})
	private List<Disponibilite> disponibilites;
	
	@OneToMany(mappedBy = "medecin")
	@JsonView({Views.Medecin.class, Views.Secretaire.class})
	private List<Consultation> consultations;
	
	@OneToMany(mappedBy = "medecin")
	@JsonView({Views.Medecin.class, Views.Secretaire.class})
	private List<MedecinSpecialite> medecinSpecialites; 

	public Medecin() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Convention getConvention() {
		return convention;
	}

	public void setConvention(Convention convention) {
		this.convention = convention;
	}

	public Boolean getCarteVitale() {
		return carteVitale;
	}

	public void setCarteVitale(Boolean carteVitale) {
		this.carteVitale = carteVitale;
	}

	public Boolean getCmu() {
		return cmu;
	}

	public void setCmu(Boolean cmu) {
		this.cmu = cmu;
	}

	public Secretaire getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public List<MedecinSpecialite> getMedecinSpecialites() {
		return medecinSpecialites;
	}

	public void setMedecinSpecialites(List<MedecinSpecialite> medecinSpecialites) {
		this.medecinSpecialites = medecinSpecialites;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public List<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}
	
	
	
	
}

