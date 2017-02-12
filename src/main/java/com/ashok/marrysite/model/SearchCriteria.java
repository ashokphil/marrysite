package com.ashok.marrysite.model;

import org.springframework.stereotype.Component;

@Component
public class SearchCriteria {
	private String agefrom;
	private String ageto;
	private String religion;
	private String gender;
	public String getAgefrom() {
		return agefrom;
	}
	public void setAgefrom(String agefrom) {
		this.agefrom = agefrom;
	} 
	public String getAgeto() {
		return ageto;
	}
	public void setAgeto(String ageto) {
		this.ageto = ageto;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
