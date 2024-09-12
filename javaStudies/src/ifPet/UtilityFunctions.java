package ifPet;

import java.util.Scanner;

import ifPet.models.*;
import ifPet.services.AppointmentService;
import ifPet.services.ClientService;
import ifPet.services.JobService;
import ifPet.services.PetService;
import ifPet.services.SpecieService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilityFunctions {	
	static Scanner myObj = new Scanner(System.in);
	static Pet myPet = new Pet(); 
	private static Client clientLogin = null;
	
	// ------------------- CRUD SPECIE ------------------------------
	
	public static void addSpecie() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		Specie specie = new Specie(id, name);
		SpecieService.ADD(specie);
	}
	public static void getSpecies() {
		System.out.println("------------------");
		for (Specie i: SpecieService.GET()) {
			System.out.println(i.getId() + " - " + i.getDescription());
		}
		System.out.println("------------------");
	}
	public static void putSpecie() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		Specie specie = new Specie(name);
		SpecieService.PUT(specie, id);
	}
	public static void removeSpecie() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		SpecieService.REMOVE(id);
	}
	
	// ------------------- CRUD PET ------------------------------
	
	public static void addPet() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		System.out.println("- Digite a raça: ");
		var race = myObj.next();
		System.out.println("- Digite a data de nascimento: ");
		var birth = myObj.next();
		System.out.println("- Digite o id da especie: ");
		getSpecies();
		var idSpecie = Integer.valueOf(myObj.next());
		System.out.println("- Digite o id do cliente: ");
		getClients();
		var idClient = Integer.valueOf(myObj.next());
		
		Pet pet = new Pet(id, name, race, birth, idSpecie, idClient);
		PetService.ADD(pet);
	}
	public static void getPets() {
		System.out.println("------------------");
		for (Pet i: PetService.GET()) {
			i.toStringPet();
		}
		System.out.println("------------------");
	}
	public static void putPet() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		System.out.println("- Digite a raça: ");
		var race = myObj.next();
		System.out.println("- Digite a data de nascimento: ");
		var birth = myObj.next();
		System.out.println("- Digite o id da especie: ");
		getSpecies();
		var idSpecie = Integer.valueOf(myObj.next());
		System.out.println("- Digite o id do cliente: ");
		getClients();
		var idClient = Integer.valueOf(myObj.next());
		Pet pet = new Pet(name, race, birth, idSpecie, idClient);
		PetService.PUT(pet, id);
	}
	public static void removePet() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		PetService.REMOVE(id);
	}
	
	// ------------------- CRUD CLIENT ------------------------------
	
	public static void addClient() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		Client client = new Client(id, name);
		ClientService.ADD(client);
	}
	public static void getClients() {
		System.out.println("------------------");
		for (Client i: ClientService.GET()) {
			System.out.println(i.getId() + " - " + i.getName());
		}
		System.out.println("------------------");
	}
	public static Client getClient(int id) {
		Client client = null;
		for (Client i: ClientService.GET()) {
			if(i.getId() == id) client = i;
			
		}
		if(client != null) return client;
		else return null;
	}
	public static void putClient() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		Client client = new Client(name);
		ClientService.PUT(client, id);
	}
	public static void removeClient() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		ClientService.REMOVE(id);
	}

	// ------------------- CRUD JOB ------------------------------
	
	public static void addJob() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		System.out.println("- Digite o preço: ");
		var price = Double.parseDouble(myObj.next());
		Job job = new Job(id, name, price);
		JobService.ADD(job);
	}
	public static void getJobs() {
		System.out.println("------------------");
		for (Job i: JobService.GET()) {
			i.toStringJob();
		}
		System.out.println("------------------");
	}
	public static void putJob() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		System.out.println("- Digite o nome: ");
		var name = myObj.next();
		System.out.println("- Digite o preço: ");
		var price = Double.parseDouble(myObj.next());
		Job job = new Job(name, price);
		JobService.PUT(job, id);
	}
	public static void removeJob() {
		System.out.println("- Digite o id: ");
		var id = Integer.valueOf(myObj.next());
		JobService.REMOVE(id);
	}
	
	// ------------------- CRUD APPOINTMENT ------------------------------
	
	public static void openAgenda() {
		System.out.println("- Digite o dia: ");
		var dayInput = myObj.next();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate day = LocalDate.parse(dayInput, formatter);
        
		AppointmentService.OpenAgenda(day);		
		System.out.println("------------");
	}
	public static void getAgenda() {
		System.out.println("------------------");
		for (Appointment i: AppointmentService.GET()) {
			System.out.println(i.toStringAppointment());
		}
		System.out.println("------------------");
	}

	// ------------------- AUTH ROUTE ------------------------------
	
	public static Client clientLogin() {
		System.out.println("-Login do cliente");
		getClients();
		System.out.println(" - Id do cliente: ");
		var id = Integer.valueOf(myObj.next());
		clientLogin = getClient(id);
		return getClient(id);
	}
	public static Client clientLogout() {
		System.out.println("------ Logout do cliente -------");
		clientLogin = null;
		return null;
	}

	// ------------------- CLIENT ROUTE ------------------------------
	
	
	public static void getOpenHours() {
		System.out.println("- Estes são os horarios disponiveis: ");
		for(Appointment i: AppointmentService.GET()) {
			if(i.getIdClient() == 0) {
				System.out.println(i.toStringAppointment());
			}
		}
		System.out.println("---------------");
	}
	public static void addAgenda() {
		System.out.println("Escolha um horario: ");
		getOpenHours();
		System.out.println("Digite o id do horario: ");
		var idHour = Integer.valueOf(myObj.next());
		getJobs();
		System.out.println("Digite o id do serviço: ");
		var idJob = Integer.valueOf(myObj.next());
		getMyPets();
		System.out.println("Digite o id do Pet: ");
		var idPet = Integer.valueOf(myObj.next());
		Appointment appointment = new Appointment(clientLogin.getId(), idJob, idPet);
		AppointmentService.PUT(appointment, idHour - 1);
	}
	public static void getMyHours() {
		System.out.println("Esses são seus horarios: ");
		for(Appointment i: AppointmentService.GET()) {
			if(i.getIdClient() == clientLogin.getId()) {
				System.out.println(i.toStringAppointment());
			}
		}
	}
	public static void getMyPets() {
		System.out.println("---- Seus pets -------");
		for (Pet i: PetService.GET()) {
			if(i.getIdClient() == clientLogin.getId()) {
				System.out.println(i.getId() + " - " + i.getName() + " - " + i.getRace());
			}
		}
		System.out.println("--------------------");
	}
	
}
