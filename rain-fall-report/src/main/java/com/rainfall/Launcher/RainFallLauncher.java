package com.rainfall.Launcher;

import com.rainfall.util.RainfallReport;

public class RainFallLauncher {
	
	public static void main(String[] args) {
		
		RainfallReport rainfallReport = new RainfallReport();
		rainfallReport.generateRainfallReport("src/main/resources/AllCityMonthlyRainfall.txt");
		System.out.println(rainfallReport.findMaximumRainfallCities());
	}

}
