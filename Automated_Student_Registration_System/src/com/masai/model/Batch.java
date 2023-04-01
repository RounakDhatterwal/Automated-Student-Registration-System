package com.masai.model;

import java.time.LocalDate;
import java.util.Date;

public class Batch {
	private String name;
	private LocalDate startdate;
	private LocalDate enddate;
	private int capacity;
	private String Strength;
	private int course_id;
	public Batch(String name, LocalDate startdate, LocalDate enddate, int capacity, int course_id) {
		super();
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.capacity = capacity;
		this.course_id = course_id;
	}
	public Batch() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity2) {
		this.capacity = capacity2;
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
