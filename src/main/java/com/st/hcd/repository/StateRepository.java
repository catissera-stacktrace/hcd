package com.st.hcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

	@Query("SELECT s FROM State s where s.id = ?")
	State findStateById(Integer stateId);

	@Query("SELECT s FROM State s where s.countryId = ?")
	List<State> findStateByCountryId(Integer countryId);
	
}

