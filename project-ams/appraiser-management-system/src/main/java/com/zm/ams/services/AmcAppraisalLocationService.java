package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.AmcAppraisalLoc;
import com.zm.ams.dto.AppraisalLoc;

public interface AmcAppraisalLocationService {
	
	void save(AmcAppraisalLoc amcAppraisalLoc) throws SQLException;
	boolean isExist(AmcAppraisalLoc amcAppraisalLoc) throws SQLException;
	List<AppraisalLoc> getLocIdByAmcId(int AmcId) throws SQLException;

}
