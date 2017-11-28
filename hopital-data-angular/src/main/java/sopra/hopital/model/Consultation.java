package sopra.hopital.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

@Entity
@SequenceGenerator(name="seqConsultation")
@Table(name="consultation")
public class Consultation {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqConsultation")
    @Id
    @JsonView(Views.Common.class)

    private Integer id;
	@Version
	@JsonView(Views.Consultation.class)
	private int version;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.Consultation.class)
	private Date dtRendezVous;
	@JsonView(Views.Consultation.class)
	private Integer duree;
	@JsonView(Views.Consultation.class)
	private String rapport;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonView(Views.Consultation.class)
	private Date dtDemarrage;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonView(Views.Consultation.class)
	private Date dtFin;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	@JsonView(Views.Consultation.class)
	private Patient patient;
	@ManyToOne
	@JoinColumn(name = "salle_id")
	@JsonView(Views.Consultation.class)
	private Salle salle;
	@ManyToOne
	@JoinColumn(name = "specialite_id")
	@JsonView(Views.Consultation.class)
	private Specialite specialite;
	@ManyToOne
	@JoinColumn(name = "medecin_id")
	@JsonView(Views.Consultation.class)
	private Medecin medecin;
	
	public Consultation(){
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

	public Date getDtRendezVous() {
		return dtRendezVous;
	}
	public void setDtRendezVous(Date dtRendezVous) {
		this.dtRendezVous = dtRendezVous;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public String getRapport() {
		return rapport;
	}
	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
	public Date getDtDemarrage() {
		return dtDemarrage;
	}
	public void setDtDemarrage(Date dtDemarrage) {
		this.dtDemarrage = dtDemarrage;
	}
	public Date getDtFin() {
		return dtFin;
	}
	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	

}
