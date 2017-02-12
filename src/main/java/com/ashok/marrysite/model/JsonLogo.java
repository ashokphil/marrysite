package com.ashok.marrysite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class JsonLogo implements Serializable {

    @JsonProperty
    @Lob
    private String image; 
    @Id
    @GeneratedValue
    private Long id;

    public String getImage() {
        return image;
    }
   
    public void setImage(String image) {
        this.image = image;
    }

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
}
