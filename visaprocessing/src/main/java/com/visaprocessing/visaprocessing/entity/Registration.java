package com.visaprocessing.visaprocessing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Registration {
@Id
	private String username;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String password;
	private String nationality;
	private String passport_number;
	private String address;
	private String zipcode;
	private String mobile;
	private String faname;
	private String fnationality;
	private String moname;
	private String mnationality;
	private String status;
	public Registration(String username, String fname, String mname, String lname, String email, String password,
			String nationality, String passport_number, String address, String zipcode, String mobile, String faname,
			String fnationality, String moname, String mnationality, String status) {
		super();
		this.username = username;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.nationality = nationality;
		this.passport_number = passport_number;
		this.address = address;
		this.zipcode = zipcode;
		this.mobile = mobile;
		this.faname = faname;
		this.fnationality = fnationality;
		this.moname = moname;
		this.mnationality = mnationality;
		this.status = status;
	}
	public Registration() {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFaname() {
		return faname;
	}
	public void setFaname(String faname) {
		this.faname = faname;
	}
	public String getFnationality() {
		return fnationality;
	}
	public void setFnationality(String fnationality) {
		this.fnationality = fnationality;
	}
	public String getMoname() {
		return moname;
	}
	public void setMoname(String moname) {
		this.moname = moname;
	}
	public String getMnationality() {
		return mnationality;
	}
	public void setMnationality(String mnationality) {
		this.mnationality = mnationality;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
