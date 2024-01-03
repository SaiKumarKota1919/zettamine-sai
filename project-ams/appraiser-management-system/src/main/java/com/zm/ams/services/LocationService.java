package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.AppraisalLoc;

public interface LocationService {
	
	AppraisalLoc getLocationByLocId(int id) throws SQLException;

}
