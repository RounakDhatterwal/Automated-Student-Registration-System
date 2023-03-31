package com.masai.model;

public class Student {
	private String firstname;
	private String lastname;
	private String address;
	private String mobile_number;
	private String email;
	private String password;
	public Student( String firstname, String lastname, String address, String mobile_number, String email,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.mobile_number = mobile_number;
		this.email = email;
		this.password = password;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", mobile_number=" + mobile_number + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
