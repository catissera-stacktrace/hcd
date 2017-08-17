package com.st.hcd.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.entity.Country;
import com.st.hcd.repository.CountryRepository;

@Service
public class CountryServiceImpl  implements CountryService {

	@Resource 
	CountryRepository countryRepository;

	@Override
	public Country getCountryById(Integer countryId) {
		return countryRepository.findCountryById(countryId);
	}

}

