package com.masai.model;

import java.time.LocalDate;
import java.util.Date;

public class Batch {
	private String name;
	private String startdate;
	private String enddate;
	private int capacity;
	private String Strength;
	private int course_id;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}
	
	public Batch(String name, String startdate, String enddate, int capacity, String strength, int course_id) {
		super();
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.capacity = capacity;
		Strength = strength;
		this.course_id = course_id;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStrength() {
		return Strength;
	}
	public void setStrength(String strength) {
		Strength = strength;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	@Override
	public String toString() {
		return "Batch [name=" + name + ", startdate=" + startdate + ", enddate=" + enddate + ", capacity=" + capacity
				+ ", Strength=" + Strength + ", course_id=" + course_id + "]";
	}
	
	
	
}
