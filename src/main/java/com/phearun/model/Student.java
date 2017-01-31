package com.phearun.model;

import java.sql.Timestamp;

public class Student {
	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private boolean status;
	private Timestamp dob;
	private String pob;
	private String phone;
	private String photo;
	
	public Student() {}
	
	public Student(int id, String firstname, String lastname, String gender, boolean status, Timestamp dob, String pob, String phone, String photo) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.status = status;
		this.dob = dob;
		this.pob = pob;
		this.phone = phone;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Timestamp getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
	public String getPob() {
		return pob;
	}
	public void setPob(String pob) {
		this.pob = pob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", status=" + status + ", dob=" + dob + ", pob=" + pob + ", phone=" + phone + ", photo=" + photo
				+ "]";
	}
}
