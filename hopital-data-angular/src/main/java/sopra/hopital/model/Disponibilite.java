package sopra.hopital.model;

import java.util.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Disponibilite {
	
	
	@Id
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	private int version;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonView(Views.Common.class)	
	private Date dtDebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonView(Views.Common.class)
	private Date dtFin;
	
	
	@ManyToOne
	@JsonView(Views.Common.class)
	private Medecin medecin;
	


	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public Date getDtFin() {
		return dtFin;
	}

	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}
	
	
	

}
