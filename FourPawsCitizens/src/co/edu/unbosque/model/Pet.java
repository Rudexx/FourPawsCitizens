package co.edu.unbosque.model;

public class Pet {

	private String id;
	private long microchip;
	private String species;
	private String sex;
	private String size;
	private Boolean potentDangerous;
	private String neighborhood;
	
	
	public Pet(long m, String spec,String sex, String size, Boolean potentDangerous, String neigh ) {
		microchip = m;
		species = spec;
		this.sex = sex;
		this.size = size;
		this.potentDangerous = potentDangerous;
		neighborhood = neigh;
	}
	
	/**
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the microchip
	 */
	public long getMicrochip() {
		return microchip;
	}
	/**
	 * @param microchip the microchip to set
	 */
	public void setMicrochip(long microchip) {
		this.microchip = microchip;
	}
	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the potentDangerous
	 */
	public Boolean getPotentDangerous() {
		return potentDangerous;
	}
	/**
	 * @param potentDangerous the potentDangerous to set
	 */
	public void setPotentDangerous(Boolean potentDangerous) {
		this.potentDangerous = potentDangerous;
	}
	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}
	/**
	 * @param neighborhood the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	
	
	
}
