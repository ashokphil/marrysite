package com.ashok.marrysite.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Education {
	@Id
	@GeneratedValue
    private Long id;
	private String education;
	private String educationdetail;
  public String getEducation() { 
		return education; 
	}
	public void setEducation(String education) {
		this.education = education; 
	}
	public String getEducationdetail() {
		return educationdetail;
	}
	public void setEducationdetail(String educationdetail) {
		this.educationdetail = educationdetail;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
