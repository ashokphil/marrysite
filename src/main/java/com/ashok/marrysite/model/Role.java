package com.ashok.marrysite.model;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String role_name; 
  public Long getId() {
		return id;
	} 
	public void setId(Long id) {
		this.id = id;  
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
