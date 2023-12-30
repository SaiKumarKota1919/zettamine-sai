package com.zm.ams.dto;

import com.zm.ams.marker.AmsDto;

public class AmcAppraisalLoc implements AmsDto{
	private int amcId;
	private int locId;
	public AmcAppraisalLoc(int amcId, int locId) {
		super();
		this.amcId = amcId;
		this.locId = locId;
	}
	public AmcAppraisalLoc() {
		super();
		
	}
	public int getAmcId() {
		return amcId;
	}
	public void setAmcId(int amcId) {
		this.amcId = amcId;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	@Override
	public String toString() {
		return "AmcAppraisalLoc [amcId=" + amcId + ", locId=" + locId + "]";
	}
	
	

}
