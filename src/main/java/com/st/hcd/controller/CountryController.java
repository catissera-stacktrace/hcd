package com.st.hcd.controller;

import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.Country;
import com.st.hcd.service.CountryService;

@RestController
@RequestMapping("/secure")
public class CountryController {

	@Resource
	CountryService countryService;

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Country getCountryById(@PathVariable Integer countryId) {

		return countryService.getCountryById(countryId);
	}
	
}
