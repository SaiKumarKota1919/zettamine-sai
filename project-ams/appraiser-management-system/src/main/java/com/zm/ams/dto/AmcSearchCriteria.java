package com.zm.ams.dto;

import com.zm.ams.marker.SearchCriteria;

public class AmcSearchCriteria implements SearchCriteria {
	private String amcName;
	private String state;
	private String city;

	public AmcSearchCriteria() {
		super();
	}


	public AmcSearchCriteria(String amcName, String state, String city) {
		super();
		this.amcName = amcName;
		this.state = state;
		this.city = city;
	}


	public String getAmcName() {
		return amcName;
	}


	public void setAmcName(String amcName) {
		this.amcName = amcName;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "AmcSearchCriteria [amcName=" + amcName + ", state=" + state + ", city=" + city + "]";
	}
	
	
	
	
}
