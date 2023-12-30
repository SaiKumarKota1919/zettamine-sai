package com.zm.ams.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zm.ams.config.JdbcConnectionFactory;
import com.zm.ams.dao.AmsDao;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.dto.AppraisalLoc;
import com.zm.ams.marker.SearchCriteria;

public class AppraisalLocationDao implements AmsDao<AppraisalLoc,SearchCriteria> {

	Connection connection;
	public AppraisalLocationDao() {
		connection= JdbcConnectionFactory.getJdbcConnection();
	}
	
	@Override
	public Optional<AppraisalLoc> get(int id) {
		return Optional.empty();
	}

	@Override
	public List<AppraisalLoc> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(AppraisalLoc t) throws SQLException  {
		String sqlQuery = "insert into ams.appraisal_loc(state,city) values(?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, t.getState());
		preparedStatement.setString(2, t.getCity());
		preparedStatement.executeUpdate();
		
	}

	@Override
	public void update(AppraisalLoc t, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AppraisalLoc t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getId(AppraisalLoc t) throws SQLException {
		String sqlQuery = "select loc_id from ams.appraisal_loc where state=? and city =?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, t.getState());
		preparedStatement.setString(2, t.getCity());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		{
			return resultSet.getInt(1);
		}
		return 0;
	}

	@Override
	public List<AppraisalLoc> getBySearchCriteria(SearchCriteria criteria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(AppraisalLoc t) throws SQLException {
		String sqlQuery = "select * from ams.appraisal_loc where state=? and city=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, t.getState());
		preparedStatement.setString(2, t.getCity());
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			return true;
		}
		
		
		return false;
	}
	
	

}
