package com.st.hcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	@Query("SELECT c FROM Country c where c.id = ?")
	Country findCountryById(Integer countryId);
	
}

