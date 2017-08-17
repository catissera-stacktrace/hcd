package com.st.hcd.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.City;
import com.st.hcd.service.CityService;

@RestController
@RequestMapping("/secure")
public class CityController {

	@Resource
	CityService cityService;

	@RequestMapping(value = "/city/{cityId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public City getCityById(@PathVariable Integer cityId) {

		return cityService.getCityById(cityId);
	}

	@RequestMapping(value = "/citiesbystate/{stateId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public List<City> getCityByStateId(@PathVariable Integer stateId) {

		return cityService.getCityByStateId(stateId);
	}
	
}
