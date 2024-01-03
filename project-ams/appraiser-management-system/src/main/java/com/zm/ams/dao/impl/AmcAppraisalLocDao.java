package com.zm.ams.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zm.ams.config.JdbcConnectionFactory;
import com.zm.ams.dao.AmsDao;
import com.zm.ams.dto.AmcAppraisalLoc;
import com.zm.ams.dto.AppraisalLoc;
import com.zm.ams.marker.SearchCriteria;

public class AmcAppraisalLocDao implements AmsDao<AmcAppraisalLoc, SearchCriteria>{


	@Override
	public Optional<AmcAppraisalLoc> get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<AmcAppraisalLoc> getAll() throws SQLException {
		List<AmcAppraisalLoc> amcAppraisalLocs = new ArrayList<AmcAppraisalLoc>();
		String sqlQuery = "select amc_id,loc_id from ams.amc_appraisal_loc";
		Statement statement = JdbcConnectionFactory.getJdbcConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		while(resultSet.next())
		{
			amcAppraisalLocs.add(new AmcAppraisalLoc(resultSet.getInt(1)
													,resultSet.getInt(2)));
		}
		
		return amcAppraisalLocs;
	}

	

	@Override
	public int getId(AmcAppraisalLoc t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isExist(AmcAppraisalLoc t) throws SQLException {
		String sqlQuery = "select * from ams.amc_appraisal_loc where amc_id=? and loc_id=?";
		
		PreparedStatement preparedStatement = JdbcConnectionFactory
											.getJdbcConnection()
											.prepareStatement(sqlQuery);
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
		PreparedStatement preparedStatement= JdbcConnectionFactory.getJdbcConnection().prepareStatement(sqlQuery);
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

	public List<AppraisalLoc> getLocByAmcId(int amcId) throws SQLException {
		List<AppraisalLoc> list = new ArrayList<AppraisalLoc>();
		String sqlQuery ="select b.loc_id,b.state,b.city  "
				+ "from ams.amc_appraisal_loc as a inner join "
				+ "ams.appraisal_loc as b "
				+ "on a.loc_id = b.loc_id  where a.amc_id=?";
		PreparedStatement preparedStatement = JdbcConnectionFactory.getJdbcConnection().prepareStatement(sqlQuery);
		preparedStatement.setInt(1, amcId);
	ResultSet resultSet = preparedStatement.executeQuery();
	while(resultSet.next())
	{
		list.add(new AppraisalLoc(resultSet.getInt(1)
								, resultSet.getString(2)
								, resultSet.getString(3)));
		
		
	}
		
		
		return list;
	}

}
