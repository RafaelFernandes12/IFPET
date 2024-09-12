package javaStudies.services;

import java.util.ArrayList;
import javaStudies.models.Specie;

public class SpecieService {
	
	private static ArrayList<Specie> species = new ArrayList<Specie>();
	
	public static void ADD(Specie obj) {
		species.add(obj);
	}
	public static ArrayList<Specie> GET() {
		return species;
	}
	public static void PUT(Specie obj, int id) {
		var specie = species.get(id);
		specie.setDescription(obj.getDescription());
	}
	public static void REMOVE(int index) {
		species.remove(index);
	}
}
