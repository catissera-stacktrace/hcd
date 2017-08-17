package com.st.hcd.service;

import java.util.List;

import com.st.hcd.entity.City;

public interface CityService {
	
	City getCityById(Integer cityId);

	List<City> getCityByStateId(Integer stateId);
}
