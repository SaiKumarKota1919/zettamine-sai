package com.zm.ams.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zm.ams.config.JdbcConnectionFactory;
import com.zm.ams.dao.AmsDao;
import com.zm.ams.dto.AmcAppraisalLoc;
import com.zm.ams.marker.SearchCriteria;

public class AmcAppraisalLocDao implements AmsDao<AmcAppraisalLoc, SearchCriteria>{

	private Connection connection = JdbcConnectionFactory.getJdbcConnection();
	@Override
	public Optional<AmcAppraisalLoc> get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<AmcAppraisalLoc> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public int getId(AmcAppraisalLoc t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isExist(AmcAppraisalLoc t) throws SQLException {
		String sqlQuery = "select * from ams.amc_appraisal_loc where amc_id=? and loc_id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, t.getAmcId());
		preparedStatement.setInt(2, t.getLocId());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void save(AmcAppraisalLoc t) throws SQLException {
		String sqlQuery = "insert into ams.amc_appraisal_loc(amc_id,loc_id) values(?,?)";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, t.getAmcId());
		preparedStatement.setInt(2, t.getLocId());
		preparedStatement.executeUpdate();
		
	}

	@Override
	public void update(AmcAppraisalLoc t, String... params) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AmcAppraisalLoc t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AmcAppraisalLoc> getBySearchCriteria(SearchCriteria criteria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
