package com.ashok.marrysite.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue
    private Long id;
	private String aboutme;
	@OneToOne(cascade = CascadeType.ALL)
	private Education education;
	@OneToOne(cascade = CascadeType.ALL)
	private Career career;
	@OneToOne(cascade = CascadeType.ALL)  
	private LifeStyle lifestyle;  
	@OneToOne(cascade = CascadeType.ALL)
	private Location location;
	@OneToOne(cascade = CascadeType.ALL)
	private Family family;  
	private String aboutmyfamily;
	@OneToOne(cascade = CascadeType.ALL)
	private Hobbies hobbies;
	@OneToOne(cascade = CascadeType.ALL)
	private ContactDetails contactdetails;
	private String aboutmypartner;
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public Career getCareer() {
		return career;
	}
	public void setCareer(Career career) {
		this.career = career;
	}
	public LifeStyle getLifestyle() {
		return lifestyle;
	}
	public void setLifestyle(LifeStyle lifestyle) {
		this.lifestyle = lifestyle;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	public String getAboutmyfamily() {
		return aboutmyfamily;
	}
	public void setAboutmyfamily(String aboutmyfamily) {
		this.aboutmyfamily = aboutmyfamily;
	}
	public Hobbies getHobbies() {
		return hobbies;
	}
	public void setHobbies(Hobbies hobbies) {
		this.hobbies = hobbies;
	}
	public ContactDetails getContactdetails() {
		return contactdetails;
	}
	public void setContactdetails(ContactDetails contactdetails) {
		this.contactdetails = contactdetails;
	}
	public String getAboutmypartner() {
		return aboutmypartner;
	}
	public void setAboutmypartner(String aboutmypartner) {
		this.aboutmypartner = aboutmypartner;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
