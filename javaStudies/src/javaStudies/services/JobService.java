package javaStudies.services;

import java.util.ArrayList;

import javaStudies.models.Job;

public class JobService {
	private static ArrayList<Job> jobs = new ArrayList<Job>();
	
	public static void ADD(Job obj) {
		jobs.add(obj);
	}
	public static ArrayList<Job> GET() {
		return jobs;
	}
	public static void PUT(Job obj, int id) {
		var job = jobs.get(id);
		job.setDescription(obj.getDescription());
	}
	public static void REMOVE(int index) {
		jobs.remove(index);
	}
}
