package com.st.hcd.security.jwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.st.hcd.security.jwt.entity.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

	List<Operator> findAll();
	
	@Query("SELECT o FROM Operator o where o.personId = ?")
	List<Operator> FindByPersonId(Integer personId);
}
