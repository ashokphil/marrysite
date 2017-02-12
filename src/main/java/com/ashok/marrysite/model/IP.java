package com.ashok.marrysite.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IP implements Serializable{
	@JsonProperty
	private String countryIso2;
	@JsonProperty
	private String stateAbbr;
	@JsonProperty
	private String postal;
	@JsonProperty
	private String continent;
	@JsonProperty
	private String state;
	@JsonProperty
	private String longitude;
	@JsonProperty
	private String latitude;
	@JsonProperty
	private String ds;
	@JsonProperty
	private String ip;
	@JsonProperty
	private String city;
	@JsonProperty
	private String country;
	public String getCountryIso2() {
		return countryIso2;
	}
	public void setCountryIso2(String countryIso2) {
		this.countryIso2 = countryIso2;
	}
	public String getStateAbbr() {
		return stateAbbr;
	}
	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getDs() {
		return ds;
	}
	public void setDs(String ds) {
		this.ds = ds;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "IP [countryIso2=" + countryIso2 + ", stateAbbr=" + stateAbbr + ", postal=" + postal + ", continent="
				+ continent + ", state=" + state + ", longitude=" + longitude + ", latitude=" + latitude + ", ds=" + ds
				+ ", ip=" + ip + ", city=" + city + ", country=" + country + "]";
	}

	
}
