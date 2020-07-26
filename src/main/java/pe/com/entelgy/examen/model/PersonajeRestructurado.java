package pe.com.entelgy.examen.model;

public class PersonajeRestructurado {

	private String species;
	private String originPlanet;
	private String name;
	
	public PersonajeRestructurado() {}
	
	public PersonajeRestructurado(String species, String originPlanet, String name) {
		this.species = species;
		this.originPlanet = originPlanet;
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getOriginPlanet() {
		return originPlanet;
	}

	public void setOriginPlanet(String originPlanet) {
		this.originPlanet = originPlanet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
