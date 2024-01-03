package com.zm.ams.dto;

import com.zm.ams.marker.AmsDto;

public class PropertyType implements AmsDto {
	private int propertyTypeId;
	private String propertyTypeDesc;
	public PropertyType(int propertyTypeId, String propertyTypeDesc) {
		super();
		this.propertyTypeId = propertyTypeId;
		this.propertyTypeDesc = propertyTypeDesc;
	}
	public PropertyType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPropertyTypeId() {
		return propertyTypeId;
	}
	public void setPropertyTypeId(int propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}
	public String getPropertyTypeDesc() {
		return propertyTypeDesc;
	}
	public void setPropertyTypeDesc(String propertyTypeDesc) {
		this.propertyTypeDesc = propertyTypeDesc;
	}
	@Override
	public String toString() {
		return "PropertyType [propertyTypeId=" + propertyTypeId + ", propertyTypeDesc=" + propertyTypeDesc + "]";
	}
	
	

}
