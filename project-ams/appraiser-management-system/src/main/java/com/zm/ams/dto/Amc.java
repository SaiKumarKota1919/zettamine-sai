package com.zm.ams.dto;

import java.time.LocalDate;

import com.zm.ams.marker.AmsDto;

public class Amc implements AmsDto {
	private int amcId;
	private String amcRegId;
	private String amcName;
	private String amcRemarks;
	private String website;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String city;
	private String zipCode;
	private LocalDate createdOn;
	private int createdBy;
	private LocalDate updatedOn;
	private int updatedBy;
	private boolean active;
	
	public Amc() {
		super();
		
	}
	
	

	public Amc(String amcName, String website, String state, String city, boolean active,int amcId) {
		super();
		this.amcName = amcName;
		this.website = website;
		this.state = state;
		this.city = city;
		this.active = active;
		this.amcId = amcId;
	}



	public Amc(String amcRegId, String amcName, String amcRemarks, String website,
			String addressLine1, String addressLine2, String state, String city, String zipCode, LocalDate createdOn,
			int createdBy, LocalDate updatedOn, int updatedBy, boolean active) {
		super();
		this.amcRegId = amcRegId;
		this.amcName = amcName;
		this.amcRemarks = amcRemarks;
		this.website = website;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
		this.active = active;
	}

	public int getAmcId() {
		return amcId;
	}

	public String getAmcRegId() {
		return amcRegId;
	}

	public void setAmcRegId(String amcRegId) {
		this.amcRegId = amcRegId;
	}

	public String getAmcName() {
		return amcName;
	}

	public void setAmcName(String amcName) {
		this.amcName = amcName;
	}

	public String getAmcRemarks() {
		return amcRemarks;
	}

	public void setAmcRemarks(String amcRemarks) {
		this.amcRemarks = amcRemarks;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
}
