package sopra.hopital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqSalle")
@Table(name = "salle")
public class Salle {  
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqSalle")
	@Id
	private Long id;
	
	@Column(name = "numero")
	private String numero;
	

}
