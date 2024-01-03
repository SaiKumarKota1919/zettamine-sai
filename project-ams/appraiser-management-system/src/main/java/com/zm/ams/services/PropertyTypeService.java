package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zm.ams.dto.PropertyType;

public interface PropertyTypeService {
	
	List<PropertyType> getAllPropertyType() throws SQLException;
	
	public PropertyType getPropertyTypeById(int id) throws SQLException;
}
