package sopra.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@SequenceGenerator(name="sequenceSpecialite")
public class Specialite {
	@Id @GeneratedValue(generator="sequenceSpecialite")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Version
	@Column(name="version")
	@JsonView(Views.Common.class)
	private int version;
	
	@Column(name="intitule")
	@JsonView(Views.Common.class)
	private String intitule;
	
	@OneToMany(mappedBy = "specialite")
	//@JsonView({Views.SpecialiteWithSalle.class})
	private List<SalleSpecialite> salleSpecialites;
	
	@OneToMany(mappedBy = "specialite")
	//@JsonView({Views.SpecialiteWithMedecin.class})
	private List<MedecinSpecialite> medecinSpecialites;
	
	public Specialite() {
		
	}
	
	public Specialite(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Specialite(String intitule, List<SalleSpecialite> listeSalleSpecialite,
			List<MedecinSpecialite> listeMedecinSpecialite) {
		super();
		this.intitule = intitule;
		this.salleSpecialites = listeSalleSpecialite;
		this.medecinSpecialites = listeMedecinSpecialite;
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

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<SalleSpecialite> getListeSalleSpecialite() {
		return salleSpecialites;
	}

	public void setListeSalleSpecialite(List<SalleSpecialite> listeSalleSpecialite) {
		this.salleSpecialites = listeSalleSpecialite;
	}

	public List<MedecinSpecialite> getListeMedecinSpecialite() {
		return medecinSpecialites;
	}

	public void setListeMedecinSpecialite(List<MedecinSpecialite> listeMedecinSpecialite) {
		this.medecinSpecialites = listeMedecinSpecialite;
	}
	
	
	
	
}
