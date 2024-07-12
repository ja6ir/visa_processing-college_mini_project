package com.visaprocessing.visaprocessing.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Apply {
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String username;
private String visa_type;
private int duration;
private String visastatus;
private String country;
public Apply(long id, String username, String visa_type, int duration, String visastatus, String country) {
	super();
	this.id = id;
	this.username = username;
	this.visa_type = visa_type;
	this.duration = duration;
	this.visastatus = visastatus;
	this.country = country;
}
public Apply() {
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
public String getVisa_type() {
	return visa_type;
}
public void setVisa_type(String visa_type) {
	this.visa_type = visa_type;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
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

}
