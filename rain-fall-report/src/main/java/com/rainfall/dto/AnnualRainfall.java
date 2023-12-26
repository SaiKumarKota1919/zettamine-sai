package com.rainfall.dto;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.Objects;
import java.util.stream.Stream;

public class AnnualRainfall implements Comparable<AnnualRainfall>{
	private int cityPincode;
	private String cityName;
	private double averageAnnualRainfall;
	
	
	
	public void calculateAverageAnnualRainfall (double monthlyRainfall[] )
	{
		DoubleSummaryStatistics doubleSummaryStatistics  =	 Arrays.stream(monthlyRainfall).summaryStatistics();
		this.averageAnnualRainfall = doubleSummaryStatistics.getAverage();
	}
	 
	
	public AnnualRainfall() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnnualRainfall(int cityPincode, String cityName, double averageAnnualRainfall) 
	{
		super();
		this.cityPincode = cityPincode;
		this.cityName = cityName;
		this.averageAnnualRainfall = averageAnnualRainfall;
	}
	@Override
	public int hashCode() {
		return Objects.hash(averageAnnualRainfall, cityName, cityPincode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnualRainfall other = (AnnualRainfall) obj;
		return Double.doubleToLongBits(averageAnnualRainfall) == Double.doubleToLongBits(other.averageAnnualRainfall)
				&& Objects.equals(cityName, other.cityName) && cityPincode == other.cityPincode;
	}
	@Override
	public String toString() {
		return "AnnualRainfall [cityPincode=" + cityPincode + ", cityName=" + cityName + ", averageAnnualRainfall="
				+ averageAnnualRainfall + "]";
	}
	public int getCityPincode() {
		return cityPincode;
	}
	public void setCityPincode(int cityPincode) {
		this.cityPincode = cityPincode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public double getAverageAnnualRainfall() {
		return averageAnnualRainfall;
	}
	public void setAverageAnnualRainfall(double averageAnnualRainfall) {
		this.averageAnnualRainfall = averageAnnualRainfall;
	}


	@Override
	public int compareTo(AnnualRainfall o) {

		
		if(this.averageAnnualRainfall-o.averageAnnualRainfall>0)
		{
			return 1;
		}
		else if(this.averageAnnualRainfall-o.averageAnnualRainfall==0) {
			return cityPincode-o.cityPincode;
			
		}
		return -1;
	}
	
	

}
