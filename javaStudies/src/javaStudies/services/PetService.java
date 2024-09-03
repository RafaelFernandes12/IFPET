package javaStudies.services;

import java.util.ArrayList;

import javaStudies.models.Pet;

public class PetService {
private static ArrayList<Pet> pets = new ArrayList<Pet>();
	
	public static void ADD(Pet obj) {
		pets.add(obj);
	}
	public static ArrayList<Pet> GET() {
		return pets;
	}
	public static void PUT(Pet obj, int id) {
		var pet = pets.get(id);
		pet.setName(obj.getName());
		pet.setRace(obj.getRace());
		pet.setBirth(obj.getBirth());
		pet.setIdSpecie(obj.getIdSpecie());
		pet.setIdClient(obj.getIdClient());
	}
	public static void REMOVE(int index) {
		pets.remove(index);
	}
}
