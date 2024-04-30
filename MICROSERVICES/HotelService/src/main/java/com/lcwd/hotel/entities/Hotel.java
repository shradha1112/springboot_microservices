package com.lcwd.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table (name = "hotels")
public class Hotel {
@Id
private String id;
private String name;
private String location;
private String about;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public Hotel(String id, String name, String location, String about) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
	this.about = about;
}
public Hotel() {
	super();
}



}
