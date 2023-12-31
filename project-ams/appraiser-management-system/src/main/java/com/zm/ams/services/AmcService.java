package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.Amc;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.marker.SearchCriteria;

public interface AmcService {
	void save(Amc amc) throws SQLException;
	List<String> getAmcNames() throws SQLException; 
	int getAmcId(Amc amc) throws SQLException;
	List<Amc> getBySearchCriteria(AmcSearchCriteria searchCriteria)throws SQLException;

}
