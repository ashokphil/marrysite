package com.ashok.marrysite.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactDetails {
	@Id
	@GeneratedValue
private Long id;
 
private String contactname;
private String relationship;
private String number;
private String profilecreatedby;
public String getContactname() { 
	return contactname; 
}
public void setContactname(String contactname) {
	this.contactname = contactname;
}
public String getRelationship() {
	return relationship;
}
public void setRelationship(String relationship) {
	this.relationship = relationship;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getProfilecreatedby() {
	return profilecreatedby;
}
public void setProfilecreatedby(String profilecreatedby) {
	this.profilecreatedby = profilecreatedby;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}


}
