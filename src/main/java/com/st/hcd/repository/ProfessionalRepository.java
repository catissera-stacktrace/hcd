package com.st.hcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

	@Query("SELECT p FROM Professional p where p.id = ?")
	Professional findProfessionalById(Integer professionalId);
	
}

