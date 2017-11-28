package sopra.hopital.model;

public enum Role {

	SECRETAIRE("role.secretaire"), MEDECIN("role.medecin"), ADMIN("role.admin");
	
	private final String label;
	
	private Role(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
