package com.st.hcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT p FROM Person p where p.email = ?")
	Person findPersonByEmail(String email);
	
	@Query("SELECT p FROM Person p where p.id = ?")
	Person findPersonById(Integer personId);
	
}

