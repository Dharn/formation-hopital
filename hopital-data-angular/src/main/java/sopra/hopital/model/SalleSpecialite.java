package sopra.hopital.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "salleSpecialite",  uniqueConstraints = @UniqueConstraint(columnNames = { "salle_id", "specialite_id" }))
public class SalleSpecialite {

}
