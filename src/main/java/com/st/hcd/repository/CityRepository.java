package com.st.hcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("SELECT c FROM City c where c.id = ?")
	City findCityById(Integer cityId);

	@Query("SELECT c FROM City c where c.stateId = ?")
	List<City> findCityByStateId(Integer stateId);
	
}

