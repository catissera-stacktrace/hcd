package com.st.hcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

	@Query("SELECT s FROM Services s where s.id = ?")
	Services findServiceById(Integer serviceId);

	@Query("SELECT s FROM Services s where s.healthCenterId = ?")
	List<Services> findServicesByHealthCenterId(Integer healthCenterId);

}

