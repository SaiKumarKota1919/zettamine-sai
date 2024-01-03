package com.zm.ams.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.impl.AppraisalLocationDao;
import com.zm.ams.dto.AppraisalLoc;
import com.zm.ams.marker.SearchCriteria;
import com.zm.ams.services.LocationService;

public class LocationServiceImpl implements LocationService{

	

	@Override
	public AppraisalLoc getLocationByLocId(int id) throws SQLException {
		
		return new AppraisalLocationDao().getById(id);
	}

}
