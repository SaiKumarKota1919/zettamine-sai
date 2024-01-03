package com.zm.ams.dto;

import com.zm.ams.marker.AmsDto;

public class AppraisalLoc implements AmsDto{
	private int locId;
	private String state;
	private String city;
	
	public AppraisalLoc() {
		super();
		
	}
	
	
	
	public AppraisalLoc(int locId, String state, String city) {
		super();
		this.locId = locId;
		this.state = state;
		this.city = city;
	}



	public AppraisalLoc(String state, String city) {
		super();
		this.state = state;
		this.city = city;
	}
	public int getLocId() {
		return locId;
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
		return "AppraisalLoc [locId=" + locId + ", state=" + state + ", city=" + city + "]";
	}
	
	
	
}