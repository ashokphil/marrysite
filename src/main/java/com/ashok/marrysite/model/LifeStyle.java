package com.ashok.marrysite.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LifeStyle {
	@Id
	@GeneratedValue
    private Long id;
	private String diet;
	private String smoke;
	private String drink;
	public String getDiet() {
		return diet;  
	}
	public void setDiet(String diet) {
		this.diet = diet;
	} 
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
