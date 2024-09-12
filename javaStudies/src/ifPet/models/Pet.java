package javaStudies.models;

import javaStudies.services.SpecieService;
import javaStudies.services.ClientService;
public class Pet {
	private int id;
	private String name;
	private String race;
	private String birth;
	private int idSpecie;
	private int idClient;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getIdSpecie() {
		return idSpecie;
	}
	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public Pet(int id, String name, String race, String birth, int idSpecie, int idClient) {
		this.id = id;
		this.name = name;
		this.race = race;
		this.birth = birth;
		this.idSpecie = idSpecie;
		this.idClient = idClient;
	}
	public Pet(String name, String race, String birth, int idSpecie, int idClient) {
		this.name = name;
		this.race = race;
		this.birth = birth;
		this.idSpecie = idSpecie;
		this.idClient = idClient;
	}
	public Pet() {}
	
	public void toStringPet() {
		var specie = SpecieService.GET();
		var specieName = "";
		for (var i: specie) {
			if(i.getId() == this.idSpecie) {
				specieName = i.getDescription();
;			}
		}
		var client = ClientService.GET();
		var clientName = "";
		for (var i: client) {
			if(i.getId() == this.idClient) {
				clientName = i.getName();
;			}
		}
		System.out.println(getId() + " - " + getName() + " - " + getRace() + " - " + getBirth() + " - " + specieName + " - " + clientName);
	}
	
}
