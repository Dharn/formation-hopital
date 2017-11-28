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

	private String numero;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	
}
