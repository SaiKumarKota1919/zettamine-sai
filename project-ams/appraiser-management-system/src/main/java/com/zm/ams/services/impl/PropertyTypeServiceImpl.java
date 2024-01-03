package com.zm.ams.services.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.impl.PropertyTypeDao;
import com.zm.ams.dto.PropertyType;
import com.zm.ams.marker.SearchCriteria;
import com.zm.ams.services.PropertyTypeService;

public class PropertyTypeServiceImpl implements PropertyTypeService {

	private AmsDao<PropertyType, SearchCriteria> propertyTypeDao;
	
	public PropertyTypeServiceImpl()
	{
		propertyTypeDao =  new PropertyTypeDao();
	}
	
	
	@Override
	public List<PropertyType> getAllPropertyType() throws SQLException {
		
		return propertyTypeDao.getAll();
	}
	@Override
	public PropertyType getPropertyTypeById(int id) throws SQLException
	{
		
		return new PropertyTypeDao().getPropertyById(id);
	}
	

}
