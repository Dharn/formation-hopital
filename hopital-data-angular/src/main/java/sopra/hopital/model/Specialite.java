package sopra.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private int version;
	
	@Column(name="intitule")
	private String intitule;
	
	@OneToMany(mappedBy = "module")
	//@JsonView({Views.SpecialiteWithSalle.class})
	private List<SalleSpecialite> listeSalleSpecialite;
	
	@OneToMany(mappedBy = "module")
	//@JsonView({Views.SpecialiteWithMedecin.class})
	private List<MedecinSpecialite> listeMedecinSpecialite;
	
	public Specialite() {
		
	}
}
