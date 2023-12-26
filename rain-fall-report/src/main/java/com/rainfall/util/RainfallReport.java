package com.rainfall.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.rainfall.dao.RainFallDAO;
import com.rainfall.dao.RainFallDaoImpl;
import com.rainfall.dto.AnnualRainfall;

public class RainfallReport {
	
	RainFallDAO rainFallDAO ;
	public RainfallReport() {

		rainFallDAO = new RainFallDaoImpl();
	
	}
	
	public List<AnnualRainfall>generateRainfallReport(String filePath)
	{
		List<AnnualRainfall> rainFallList = new ArrayList<AnnualRainfall>();
		File file = new File(filePath);
		try {
		
			Scanner scanner = new Scanner(file);
			int lineNumber =0;
			while(scanner.hasNextLine())
			{
				lineNumber++;
				String data[] = scanner.nextLine().split(",");
				if(data.length!=14)
				{
					System.out.println("corrupted data found at line No :"+lineNumber);
					continue;
				}
				if(validate(data[0]))
				{
					AnnualRainfall annualRainfall = new AnnualRainfall();
					annualRainfall.setCityPincode(Integer.parseInt(data[0]));
					annualRainfall.setCityName(data[1]);
					
					
					double rainFall[] = new double[data.length-2];
					for(int i=0;i<rainFall.length;i++)
					{
						rainFall[i]=Double.parseDouble(data[i+2]);
					}
					annualRainfall.calculateAverageAnnualRainfall(rainFall);
					rainFallList.add(annualRainfall);
					
					
				}
				else {
					System.out.println("Invalid Pincode found with "+data[0]);
				}
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rainFallDAO.insertRainFallData(rainFallList);
		return rainFallList;
		
	}
	public boolean validate(String cityPincode)
	{
		return cityPincode.matches("[0-9]{5}");
	}
	
	public List<AnnualRainfall> findMaximumRainfallCities()
	{
		return  rainFallDAO.getAnnualRainfalls().stream()
		  								.collect(Collectors.groupingBy(annualRainfall->annualRainfall.getAverageAnnualRainfall(),
		  																TreeMap::new,
		  																Collectors.toList()))
		  								.lastEntry()
		  								.getValue();
		
	}

}
