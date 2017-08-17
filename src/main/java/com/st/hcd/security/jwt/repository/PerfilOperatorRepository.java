package com.st.hcd.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.st.hcd.security.jwt.entity.PerfilOperator;

@Repository
public interface PerfilOperatorRepository extends JpaRepository<PerfilOperator, Long> {

	PerfilOperator findByOperatorId(int operatorId);
	
	int findByPerfilId(int perfilId);
	
}
