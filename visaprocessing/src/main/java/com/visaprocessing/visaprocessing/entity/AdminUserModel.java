package com.visaprocessing.visaprocessing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdminUserModel {
	@Id
    private String username;
    private String fname;
    private String mname;
    private String lname;
    private String email;
    private String mobile;
    private String address;
    private String zipcode;
    private String nationality;
    private String faname;
    private String moname;
    // Add getters and setters
	public AdminUserModel(String username, String fname, String mname, String lname, String email, String mobile,
			String address, String zipcode, String nationality, String faname, String moname) {
		super();
		this.username = username;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.zipcode = zipcode;
		this.nationality = nationality;
		this.faname = faname;
		this.moname = moname;
	}
	public AdminUserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getFaname() {
		return faname;
	}
	public void setFaname(String faname) {
		this.faname = faname;
	}
	public String getMoname() {
		return moname;
	}
	public void setMoname(String moname) {
		this.moname = moname;
	}
	public void setVisaStatus(String visastatus) {
		// TODO Auto-generated method stub
		
	}
}
