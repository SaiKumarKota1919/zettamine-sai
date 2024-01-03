package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.Project;

public interface ProjectService {
	void addProject(Project project) throws SQLException;
	List<Project> getAllProjectsByAmc(int amcId) throws SQLException;

}
