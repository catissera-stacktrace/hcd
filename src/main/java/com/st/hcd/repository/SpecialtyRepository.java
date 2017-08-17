package com.st.hcd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {

	@Query("SELECT s FROM Specialty s where s.id = ?")
	Specialty findSpecialtyById(Integer stateId);

	@Query("SELECT s FROM Specialty s")
	List<Specialty> findSpecialties();
	
}

