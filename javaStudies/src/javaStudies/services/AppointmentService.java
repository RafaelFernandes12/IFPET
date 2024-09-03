package javaStudies.services;

import java.util.ArrayList;
import java.time.LocalDateTime;
import javaStudies.models.Appointment;
import java.time.LocalDate;

public class AppointmentService {
	
	private static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	public static void ADD(Appointment obj) {
		int id = 0;
		
		for(Appointment i: appointments) {
			if(i.getId() > id) {
				id = i.getId();
			}
		}
		obj.setId(id + 1);

		appointments.add(obj);
	}
	public static ArrayList<Appointment> GET() {
		return appointments;
	}
	public static void PUT(Appointment obj, int id) {
		var job = appointments.get(id);
		job.setIdClient(obj.getIdClient());
		job.setIdJob(obj.getIdJob());
		job.setIdPet(obj.getIdPet());
	}
	public static void REMOVE(int index) {
		appointments.remove(index);
	}
	public static void OpenAgenda(LocalDate day) {
        int[] hours = {8, 9, 10, 11, 12, 14, 15, 16};
        LocalDate targetDate = (day != null) ? day : LocalDate.now();
        
        for (int i : hours) {
        	LocalDateTime appointmentTime = targetDate.atTime(i, 0);
            Appointment appointment = new Appointment(appointmentTime);
            AppointmentService.ADD(appointment);
        }
    }
}
