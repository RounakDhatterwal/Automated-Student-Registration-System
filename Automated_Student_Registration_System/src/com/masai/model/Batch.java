package com.masai.model;

import java.time.LocalDate;
import java.util.Date;

public class Batch {
	private String name;
	private Date startdate;
	private Date enddate;
	private String capacity;
	private String Strength;
	private int course_id;
	public Batch(String name, Date startdate, Date enddate, String capacity, int course_id) {
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
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
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
