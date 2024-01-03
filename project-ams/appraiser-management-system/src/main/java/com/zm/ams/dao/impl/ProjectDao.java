package com.zm.ams.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zm.ams.config.JdbcConnectionFactory;
import com.zm.ams.dao.AmsDao;
import com.zm.ams.dto.Project;
import com.zm.ams.marker.AmsDto;
import com.zm.ams.marker.SearchCriteria;

public class ProjectDao implements AmsDao<Project, SearchCriteria> 
{
	private Connection connection;
	
	public ProjectDao() {
		connection = JdbcConnectionFactory.getJdbcConnection();
	}

	@Override
	public Optional<Project> get(int id) throws SQLException {
		
		return Optional.empty();
	}
	//public Project(int propertyTypeId, String projectClient, LocalDate projectStartDate, LocalDate projectEndDate,
		//	double estimateValue, int locationId)
	@Override
	public List<Project> getAll() throws SQLException {
		List<Project> list = new ArrayList<Project>();
		String sqlQuery = "select prop_type_id,proj_client,proj_start_dt"
								+ ",proj_end_dt,estimate_value,loc_id,amc_id from ams.amc_project";
		ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);
		while(resultSet.next())
		{
			list.add(new Project(resultSet.getInt(1),
					resultSet.getString(2),
					resultSet.getDate(3).toLocalDate(),
					resultSet.getDate(4).toLocalDate(),
					resultSet.getDouble(5),
					resultSet.getInt(6),
					resultSet.getInt(7)));
			System.out.println(resultSet.getInt(7));
		}
		return list;
	}

	@Override
	public List<Project> getBySearchCriteria(SearchCriteria criteria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId(Project t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isExist(Project t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Project t) throws SQLException {
		String sqlQuery = "insert into ams.amc_project"
						+ "(amc_id,prop_type_id,proj_client,proj_remarks,client_remarks,"
						+ "proj_start_dt,proj_end_dt,estimate_value,loc_id) "
						+ "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, t.getAmcId());
		preparedStatement.setInt(2, t.getPropertyTypeId());
		preparedStatement.setString(3, t.getProjectClient());
		preparedStatement.setString(4,t.getProjectRemark());
		preparedStatement.setString(5,t.getClientRemarks());
		preparedStatement.setDate(6, Date.valueOf(t.getProjectStartDate()));
		preparedStatement.setDate(7, Date.valueOf(t.getProjectEndDate()));
		preparedStatement.setDouble(8, t.getEstimateValue());
		preparedStatement.setInt(9, t.getLocationId());
		preparedStatement.executeUpdate();
		
	}

	@Override
	public void update(Project t, String... params) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Project t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
