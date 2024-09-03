package javaStudies;

import java.util.Scanner;

import javaStudies.models.Client;

public class Main {
	
	static Scanner myObj = new Scanner(System.in);
	private static Client clientLogin =  null;
	public static void main(String[] args) {
		int op = 0;
		var perfil = 0;
			do {
				try {
					if(perfil == 0) {
						op = 0;
						perfil = MenuUser();
					}
					if(perfil == 1) {
						op = MenuAdmin();
						switch(op) {
							case 1: UtilityFunctions.addSpecie(); break;
							case 2: UtilityFunctions.getSpecies(); break;
							case 3: UtilityFunctions.putSpecie(); break;
							case 4: UtilityFunctions.removeSpecie(); break;
							case 5: UtilityFunctions.addPet(); break;
							case 6: UtilityFunctions.getPets(); break;
							case 7: UtilityFunctions.putPet(); break;
							case 8: UtilityFunctions.removePet(); break;
							case 9: UtilityFunctions.addClient(); break;
							case 10: UtilityFunctions.getClients(); break;
							case 11: UtilityFunctions.putClient(); break;
							case 12: UtilityFunctions.removeClient(); break;
							case 13: UtilityFunctions.addJob(); break;
							case 14: UtilityFunctions.getJobs(); break;
							case 15: UtilityFunctions.putJob(); break;
							case 16: UtilityFunctions.removeJob(); break;
							case 17: UtilityFunctions.openAgenda(); break;
							case 18: UtilityFunctions.getAgenda(); break;
							case 99: perfil = 0; break;
						}
					}
					if(perfil == 2 && clientLogin == null) {
						op = MenuClientLogin();
						switch(op) {
							case 1: clientLogin = UtilityFunctions.clientLogin(); break;
							case 99: perfil = 0; break;
						}

					}
					if(perfil == 2 && clientLogin != null) {
						op = MenuClientLogout();
						switch(op) {
						case 0: perfil = 0; break;
						case 1: UtilityFunctions.getOpenHours(); break;
						case 2: UtilityFunctions.addAgenda(); break;
						case 3: UtilityFunctions.getMyHours(); break;
						case 4: UtilityFunctions.getMyPets(); break;
						case 99: clientLogin = UtilityFunctions.clientLogout(); break;
						}
					}
				
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} while (op != 0);			
	}

	
	public static int MenuAdmin() {	
		System.out.println();
		System.out.println("--- Escolha uma opção ----");
		System.out.println("00 - Encerrar");
		System.out.println("01 - Criar Espécie");
		System.out.println("02 - Listar Espécies");
		System.out.println("03 - Atualizar Espécie");
		System.out.println("04 - Remover Espécie");
		System.out.println("05 - Criar Pet");
		System.out.println("06 - Listar Pets");
		System.out.println("07 - Atualizar Pet");
		System.out.println("08 - Remove Pet");
		System.out.println("09 - Criar Cliente");
		System.out.println("10 - Listar Clientes");
		System.out.println("11 - Atualizar Cliente");
		System.out.println("12 - Remover Cliente");
		System.out.println("13 - Criar Serviço");
		System.out.println("14 - Listar Serviços");
		System.out.println("15 - Atualizar Serviços");
		System.out.println("16 - Remove Serviços");
		System.out.println("17 - Abrir Agenda");
		System.out.println("18 - Consultar Agenda");
		System.out.println("99 - Sair");
		System.out.println();
		System.out.println("Digite sua opção: ");
		int op = Integer.valueOf(myObj.nextLine());
		return (int) op;
	}
	public static int MenuUser() {	
		System.out.println();
		System.out.println("--- Escolha uma opção ----");
		System.out.println("00 - Encerrar");
		System.out.println("01 - Entrar como adm");
		System.out.println("02 - Entrar como cliente");
		System.out.println("---------------------------");
		System.out.println("Digite sua opção: ");
		int op = Integer.valueOf(myObj.nextLine());
		return (int) op;
	}
	public static int MenuClientLogin() {	
		System.out.println();
		System.out.println("--- Escolha uma opção ----");
		System.out.println("00 - Encerrar");
		System.out.println("01 - Login");
		System.out.println("99 - Voltar");
		System.out.println("---------------------------");
		System.out.println("Digite sua opção: ");
		int op = Integer.valueOf(myObj.nextLine());
		return (int) op;
	}
	public static int MenuClientLogout() {	
		System.out.println();
		System.out.println("--- Escolha uma opção ----");
		System.out.println("Bem vindo(a) - " + clientLogin.getName());
		System.out.println("00 - Encerrar");
		System.out.println("01 - Consultar horarios disponiveis");
		System.out.println("02 - Agendar um atendimento");
		System.out.println("03 - Listar meus atendimentos");
		System.out.println("04 - Listar meus Pets");
		System.out.println("99 - Logout");
		System.out.println("---------------------------");
		System.out.println("Digite sua opção: ");
		int op = Integer.valueOf(myObj.nextLine());
		return (int) op;
	}
}
