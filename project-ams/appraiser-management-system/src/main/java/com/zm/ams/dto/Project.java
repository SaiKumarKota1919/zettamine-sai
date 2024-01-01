package com.zm.ams.dto;

import java.time.LocalDate;

public class Project {
private int pojectId;
private int amcId;
private int propertyTypeId;
private String projectClient;
private String projectRemark;
private String clientRemarks;
private LocalDate projectStartDate;
private LocalDate projectEndDate;
private double estimateValue;
private int LocationId;
public Project(int amcId, int propertyTypeId, String projectClient, String projectRemark, String clientRemarks,
		LocalDate projectStartDate, LocalDate projectEndDate, double estimateValue, int locationId) {
	super();
	this.amcId = amcId;
	this.propertyTypeId = propertyTypeId;
	this.projectClient = projectClient;
	this.projectRemark = projectRemark;
	this.clientRemarks = clientRemarks;
	this.projectStartDate = projectStartDate;
	this.projectEndDate = projectEndDate;
	this.estimateValue = estimateValue;
	LocationId = locationId;
}
public int getPojectId() {
	return pojectId;
}
public int getAmcId() {
	return amcId;
}
public void setAmcId(int amcId) {
	this.amcId = amcId;
}
public int getPropertyTypeId() {
	return propertyTypeId;
}
public void setPropertyTypeId(int propertyTypeId) {
	this.propertyTypeId = propertyTypeId;
}
public String getProjectClient() {
	return projectClient;
}
public void setProjectClient(String projectClient) {
	this.projectClient = projectClient;
}
public String getProjectRemark() {
	return projectRemark;
}
public void setProjectRemark(String projectRemark) {
	this.projectRemark = projectRemark;
}
public String getClientRemarks() {
	return clientRemarks;
}
public void setClientRemarks(String clientRemarks) {
	this.clientRemarks = clientRemarks;
}
public LocalDate getProjectStartDate() {
	return projectStartDate;
}
public void setProjectStartDate(LocalDate projectStartDate) {
	this.projectStartDate = projectStartDate;
}
public LocalDate getProjectEndDate() {
	return projectEndDate;
}
public void setProjectEndDate(LocalDate projectEndDate) {
	this.projectEndDate = projectEndDate;
}
public double getEstimateValue() {
	return estimateValue;
}
public void setEstimateValue(double estimateValue) {
	this.estimateValue = estimateValue;
}
public int getLocationId() {
	return LocationId;
}
public void setLocationId(int locationId) {
	LocationId = locationId;
}
@Override
public String toString() {
	return "Project [pojectId=" + pojectId + ", amcId=" + amcId + ", propertyTypeId=" + propertyTypeId
			+ ", projectClient=" + projectClient + ", projectRemark=" + projectRemark + ", clientRemarks="
			+ clientRemarks + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate
			+ ", estimateValue=" + estimateValue + ", LocationId=" + LocationId + "]";
}




	
}
