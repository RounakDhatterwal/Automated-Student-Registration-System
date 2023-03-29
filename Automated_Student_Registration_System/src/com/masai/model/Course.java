package com.masai.model;

public class Course {
	private int id;
	private String name;
	private int fee;
	private int duration;
	private String description;
	public Course(int id, String name, int fee, int duration, String description) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
		this.duration = duration;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee + ", duration=" + duration + ", description="
				+ description + "]";
	}
	
}
