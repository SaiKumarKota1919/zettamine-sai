package com.zm.ams.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zm.ams.config.JdbcConnectionFactory;
import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.impl.ProjectDao;
import com.zm.ams.dto.Project;
import com.zm.ams.marker.SearchCriteria;
import com.zm.ams.services.ProjectService;

public class ProjectServiceImpl implements ProjectService{
private AmsDao<Project, SearchCriteria> amsDao;

	public ProjectServiceImpl()
	{
		amsDao = new ProjectDao();
	}
	@Override
	public void addProject(Project project) throws SQLException {
		
		project.setProjectClient(project.getProjectClient().toUpperCase());
	
        amsDao.save(project);
	}

	@Override
	public List<Project> getAllProjectsByAmc(int amcId) throws SQLException {
		List<Project> list = new ArrayList<Project>();
		for(Project project:amsDao.getAll())
		{
			if(project.getAmcId()==amcId)
			{
				list.add(project);
			}
		}
		
		return list;
	}

}
