package sopra.hopital.model;

import java.util.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Disponibilite {
	
	@Id
	
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	
	private int version;
	
	
	

}
