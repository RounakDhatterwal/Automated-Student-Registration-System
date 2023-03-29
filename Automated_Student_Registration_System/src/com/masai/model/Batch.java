package com.masai.model;

public class Batch {
	private String name;
	private String startdate;
	private String enddate;
	private String capacity;
	private String Strength;
	public Batch(String name, String startdate, String enddate, String capacity, String strength) {
		super();
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.capacity = capacity;
		Strength = strength;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getStrength() {
		return Strength;
	}
	public void setStrength(String strength) {
		Strength = strength;
	}
	@Override
	public String toString() {
		return "Batch [name=" + name + ", startdate=" + startdate + ", enddate=" + enddate + ", capacity=" + capacity
				+ ", Strength=" + Strength + "]";
	}
	
}
