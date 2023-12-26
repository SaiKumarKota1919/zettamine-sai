package com.rainfall.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.rainfall.config.ConnectionFactory;
import com.rainfall.dto.AnnualRainfall;

public interface RainFallDAO {
	
	public int insertRainFallData(List<AnnualRainfall> rainfalls);
	public List<AnnualRainfall> getAnnualRainfalls();
	public boolean isAlreadyExist(int cityPincode);
	
	
	

}
