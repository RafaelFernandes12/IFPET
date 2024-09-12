package ifPet.services;

import java.util.ArrayList;

import ifPet.models.Client;
import ifPet.models.Pet;

public class ClientService {
	
	private static ArrayList<Client> clients = new ArrayList<Client>();
	
	public static void ADD(Client obj) {
		clients.add(obj);
	}
	public static ArrayList<Client> GET() {
		return clients;
	}
	public static void PUT(Client obj, int id) {
		var client = clients.get(id);
		client.setName(obj.getName());
	}
	public static void REMOVE(int index) {
		clients.remove(index);
	}
	public static ArrayList<Pet> findPets(Client client) {
		ArrayList<Pet> pets = new ArrayList<Pet>();
		var clientPets = PetService.GET();
		for(Pet i : clientPets) {
			if(i.getIdClient() == client.getId()) {
				pets.add(i);
			}
		}
		return pets;
	}
}
