package com.ashok.marrysite.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Family {
	@Id
	@GeneratedValue
    private Long id;
	private String familytype;
	private String familystatus;
	private String familyvalue;
	private String fatherfamilyname;
	private String fatherancestralhome;
	private String fatheremployedin; 
	private String parish;  
	private String noofbrothers;
	private String noofsisters;
	private String noofsistersmarried;
	private String mothersfamilyname;
	private String mothersancestralhome;
	private String motheremployedin;
	
	public String getFamilytype() {
		return familytype;
	}
	public void setFamilytype(String familytype) {
		this.familytype = familytype;
	}
	public String getFamilystatus() {
		return familystatus;
	}
	public void setFamilystatus(String familystatus) {
		this.familystatus = familystatus;
	}
	public String getFamilyvalue() {
		return familyvalue;
	}
	public void setFamilyvalue(String familyvalue) {
		this.familyvalue = familyvalue;
	}
	public String getFatherfamilyname() {
		return fatherfamilyname;
	}
	public void setFatherfamilyname(String fatherfamilyname) {
		this.fatherfamilyname = fatherfamilyname;
	}
	public String getFatherancestralhome() {
		return fatherancestralhome;
	}
	public void setFatherancestralhome(String fatherancestralhome) {
		this.fatherancestralhome = fatherancestralhome;
	}
	public String getFatheremployedin() {
		return fatheremployedin;
	}
	public void setFatheremployedin(String fatheremployedin) {
		this.fatheremployedin = fatheremployedin;
	}
	public String getParish() {
		return parish;
	}
	public void setParish(String parish) {
		this.parish = parish;
	}
	public String getNoofbrothers() {
		return noofbrothers;
	}
	public void setNoofbrothers(String noofbrothers) {
		this.noofbrothers = noofbrothers;
	}
	public String getNoofsisters() {
		return noofsisters;
	}
	public void setNoofsisters(String noofsisters) {
		this.noofsisters = noofsisters;
	}
	public String getNoofsistersmarried() {
		return noofsistersmarried;
	}
	public void setNoofsistersmarried(String noofsistersmarried) {
		this.noofsistersmarried = noofsistersmarried;
	}
	public String getMothersfamilyname() {
		return mothersfamilyname;
	}
	public void setMothersfamilyname(String mothersfamilyname) {
		this.mothersfamilyname = mothersfamilyname;
	}
	public String getMothersancestralhome() {
		return mothersancestralhome;
	}
	public void setMothersancestralhome(String mothersancestralhome) {
		this.mothersancestralhome = mothersancestralhome;
	}
	public String getMotheremployedin() {
		return motheremployedin;
	}
	public void setMotheremployedin(String motheremployedin) {
		this.motheremployedin = motheremployedin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


}
