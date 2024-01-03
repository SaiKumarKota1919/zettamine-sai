package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.AppraisalLoc;

public interface AppraisalLocationService {
	
	void save(AppraisalLoc appraisalLoc) throws SQLException;
	int getId(AppraisalLoc appraisalLoc)  throws SQLException;
	boolean isExist(AppraisalLoc appraisalLoc) throws SQLException;

}
