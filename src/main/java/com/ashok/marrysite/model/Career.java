package com.ashok.marrysite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Career {
	@Id
	@GeneratedValue
private Long id;
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
private String employedin; 
private String income;
private String occupation; 
public String getEmployedin() { 
	return employedin;
}
public void setEmployedin(String employedin) {
	this.employedin = employedin;
}
public String getIncome() {
	return income;
}
public void setIncome(String income) {
	this.income = income;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}

}
