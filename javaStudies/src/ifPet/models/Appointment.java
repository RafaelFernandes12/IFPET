package ifPet.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ifPet.services.ClientService;
import ifPet.services.JobService;
import ifPet.services.PetService;
public class Appointment {
    private int id;
    private LocalDateTime day;
    private int idClient;
    private int idJob;
    private int idPet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public Appointment(int id, LocalDateTime day, int idClient, int idJob, int idPet) {
        this.id = id;
        this.day = day;
        this.idClient = idClient;
        this.idJob = idJob;
        this.idPet = idPet;
    }

    public Appointment(int idClient, int idJob, int idPet) {
        this.idClient = idClient;
        this.idJob = idJob;
        this.idPet = idPet;
    }

    public Appointment(LocalDateTime day) {
        this.day = day;
    }

    public String toStringAppointment() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDate = day.format(formatter);
		var client = ClientService.GET();
		var clientName = "";
		for (var i: client) {
			if(i.getId() == this.idClient) {
				clientName = i.getName();
;			}
		}
		var job = JobService.GET();
		var jobName = "";
		for (var i: job) {
			if(i.getId() == this.idClient) {
				jobName = i.getDescription();
;			}
		}
		var pet = PetService.GET();
		var petName = "";
		for (var i: pet) {
			if(i.getId() == this.idPet) {
				petName = i.getName();
;			}
		}
		var string = getId() + " - " + formattedDate;
        if (idClient == 0) {
            string += " - " + "Disponivel";
        }
        else {
        	string += " - " + jobName + " - " + clientName + " - " + petName;
        }
        return string;
    }
}

