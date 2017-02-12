package com.ashok.marrysite.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.Blob;
@Component
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "email",unique=true)
	private String email;  
	private String loginname;
	private String password;
	private String name;
	private String gender;   
	private String dob; 
	private String religion;
	private String caste;
	private byte[] photo;
	private String country; 
	private String location;
	private String mobileno;
	@OneToOne(cascade = CascadeType.ALL)
	private JsonLogo jsonLogo;
	@OneToMany(fetch = FetchType.EAGER)
	private List<User> expressedinterests;
	public JsonLogo getJsonLogo() {
		return jsonLogo;
	}
	public void setJsonLogo(JsonLogo jsonLogo) {
		this.jsonLogo = jsonLogo;
	}
	@OneToOne(cascade = CascadeType.ALL)	
	private Role role;
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetails userdetails;
	public Long getId() { 
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() { 
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	} 
	public String getDob() {
		return dob;   
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public List<User> getExpressedinterests() {
		return expressedinterests;
	}
	public void setExpressedinterests(List<User> expressedinterests) {
		this.expressedinterests = expressedinterests;
	}

	

}
