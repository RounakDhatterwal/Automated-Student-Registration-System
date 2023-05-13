package com.masai.model;

// it a model class for getting consolidated record

public class Consolidate {
	
	private int st_id;
	private int bt_id;
	private int c_id;
	
	public Consolidate() {
		// TODO Auto-generated constructor stub
	}

	public Consolidate(int st_id, int bt_id, int c_id) {
		super();
		this.st_id = st_id;
		this.bt_id = bt_id;
		this.c_id = c_id;
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public int getBt_id() {
		return bt_id;
	}

	public void setBt_id(int bt_id) {
		this.bt_id = bt_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	@Override
	public String toString() {
		return "Student ID = " + st_id + ", Batch ID = " + bt_id + ", Course ID = " + c_id + "";
	}
	
	
}
