package com.ashok.marrysite.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue
private Long id;
private String currentcountry;
private String currentlocation;
private String nativeplace;
private String permenantlocation; 
private String residentialstatus;
public String getCurrentcountry() {
	return currentcountry;
} 
public void setCurrentcountry(String currentcountry) {
	this.currentcountry = currentcountry;
} 
public String getCurrentlocation() {
	return currentlocation;
}
public void setCurrentlocation(String currentlocation) {
	this.currentlocation = currentlocation;
}
public String getNativeplace() {
	return nativeplace;
}
public void setNativeplace(String nativeplace) {
	this.nativeplace = nativeplace;
}
public String getPermenantlocation() {
	return permenantlocation;
}
public void setPermenantlocation(String permenantlocation) {
	this.permenantlocation = permenantlocation;
}
public String getResidentialstatus() {
	return residentialstatus;
}
public void setResidentialstatus(String residentialstatus) {
	this.residentialstatus = residentialstatus;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}



}
