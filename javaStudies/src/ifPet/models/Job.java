package javaStudies.models;

public class Job {
	private int id;
	private String description;
	private double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Job(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}
	public Job(String description, double price) {
		this.description = description;
		this.price = price;
	}
	public Job() {}
	public void toStringJob() {
		System.out.println(getId() + " - " + getDescription() + " - " + getPrice());
	}
}
