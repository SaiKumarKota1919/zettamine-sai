package com.rainfall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rainfall.config.ConnectionFactory;
import com.rainfall.dto.AnnualRainfall;

public class RainFallDaoImpl implements RainFallDAO {

	PreparedStatement preparedStatement =null;
	Statement statement  =null;
	public RainFallDaoImpl() {

		try {
			 statement = ConnectionFactory.getJdbConnection().createStatement();
			 preparedStatement = ConnectionFactory.getJdbConnection().prepareStatement(""
					+ "insert into annualrainfall values(?,?,?)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int insertRainFallData(List<AnnualRainfall> rainfalls) {
		for(AnnualRainfall annualRainfall:rainfalls)
		{
			if(!isAlreadyExist(annualRainfall.getCityPincode()))
			{
				try {
					preparedStatement.setInt(1, annualRainfall.getCityPincode());
					preparedStatement.setString(2, annualRainfall.getCityName());
					preparedStatement.setDouble(3, annualRainfall.getAverageAnnualRainfall());
					preparedStatement.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		return 0;
	}

	@Override
	public List<AnnualRainfall> getAnnualRainfalls() {
		List<AnnualRainfall> list = new ArrayList<AnnualRainfall>();
		try {
		ResultSet resultSet =	statement.executeQuery("select * from annualrainfall");
		
		while(resultSet.next())
		{
			AnnualRainfall annualRainfall = new AnnualRainfall();
			annualRainfall.setCityPincode(resultSet.getInt(1));
			annualRainfall.setCityName(resultSet.getString(2));
			annualRainfall.setAverageAnnualRainfall(resultSet.getDouble(3));
			list.add(annualRainfall);
			
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public boolean isAlreadyExist(int cityPincode) {
		
		try {
			ResultSet resultSet = statement.executeQuery("select * from annualrainfall where city_pincode="+cityPincode);
		
				if(resultSet.next())
				{
					return true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}
