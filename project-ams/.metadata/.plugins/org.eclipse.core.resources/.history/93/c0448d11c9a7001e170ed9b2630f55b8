package com.zm.ams.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.impl.AmcJdbcDao;
import com.zm.ams.dto.Amc;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.marker.SearchCriteria;
import com.zm.ams.services.AmcService;

public class AmcServiceImpl implements AmcService {
	AmsDao< Amc, AmcSearchCriteria> amsDao = new AmcJdbcDao();
	
	
	@Override
	public void save(Amc amc) throws SQLException {
		amc.setAmcName(amc.getAmcName().toUpperCase());
		amc.setCity(amc.getCity().toUpperCase());
		amc.setState(amc.getState().toUpperCase());
		
		amsDao.save(amc);
		
		
	}


	@Override
	public List<String> getAmcNames() throws SQLException {
		return ((AmcJdbcDao) amsDao).getAmcNames();
	}


	@Override
	public int getAmcId(Amc amc) throws SQLException {
		
		return amsDao.getId(amc);
	}


	@Override
	public List<Amc> getBySearchCriteria(AmcSearchCriteria searchCriteria) throws SQLException {
		
		return amsDao.getBySearchCriteria(searchCriteria);
	}

}
