package sopra.hopital.model;

public enum Convention {
	
	SECTEUR_1("convention.secteur1"), SECTEUR_2("convention.secteur2"), NC("convention.nc");

	private final String label;

	private Convention(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
