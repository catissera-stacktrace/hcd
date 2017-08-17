package com.st.hcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.HealthCenter;

@Repository
public interface HealthCenterRepository extends JpaRepository<HealthCenter, Integer> {

	List<HealthCenter> findAll();

	@Query("SELECT h FROM HealthCenter h where h.id = ?")
	HealthCenter findHealtCenterById(Integer id);
}

