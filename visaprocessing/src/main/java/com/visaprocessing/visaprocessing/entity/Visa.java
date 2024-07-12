package com.visaprocessing.visaprocessing.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="apply")
public class Visa {
	@Id
	private long id;
	private String username;
	private String address;
	private String zipcode;
	private String mobile;
	private String faname;
	private String fnationality;
	private String moname;
	private String mnationality;
	private String status;
	private String visa_type;
	private String visastatus;
	private String country;	
	private String duration;
	private Timestamp date;
	
	public Visa(long id, String username, String address, String zipcode, String mobile, String faname,
			String fnationality, String moname, String mnationality, String status, String visa_type,
			String visastatus,String duration,String country, Timestamp date) {
		super();
		this.id = id;
		this.username = username;
		this.address = address;
		this.zipcode = zipcode;
		this.mobile = mobile;
		this.faname = faname;
		this.fnationality = fnationality;
		this.moname = moname;
		this.mnationality = mnationality;
		this.status = status;
		this.visa_type = visa_type;
		this.visastatus = visastatus;
	this.duration =duration;
	this.date = date;
	this.country= country;
	}
	public Visa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getVisa_type() {
		return visa_type;
	}
	public void setVisa_type(String visa_type) {
		this.visa_type = visa_type;
	}
	public String getVisastatus() {
		return visastatus;
	}
	public void setVisastatus(String visastatus) {
		this.visastatus = visastatus;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
