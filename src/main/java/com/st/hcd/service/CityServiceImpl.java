package com.st.hcd.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.entity.City;
import com.st.hcd.repository.CityRepository;

@Service
public class CityServiceImpl  implements CityService {

	@Resource 
	CityRepository cityRepository;

	@Override
	public City getCityById(Integer cityId) {
		return cityRepository.findCityById(cityId);
	}

	@Override
	public List<City> getCityByStateId(Integer stateId) {
		return cityRepository.findCityByStateId(stateId);
	}

}

