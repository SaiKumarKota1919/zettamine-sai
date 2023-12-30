package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.Amc;

public interface AmcService {
	void save(Amc amc) throws SQLException;
	List<String> getAmcNames() throws SQLException; 
	int getAmcId(Amc amc) throws SQLException;

}
