package com.masai.model;

public class Course {
	private String name;
	private int fee;
	private int duration;
	private String description;
	private boolean is_deleted;
	public Course( String name, int fee, int duration, String description) {
		super();

		this.name = name;
		this.fee = fee;
		this.duration = duration;
		this.description = description;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Course Name = " + name + ", Fee = " + fee + ", Duration = " + duration + ", Description = "
				+ description ;
	}
	
}
