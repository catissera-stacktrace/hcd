package com.st.hcd.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.hcd.security.jwt.entity.OperatorRole;

@Repository
public interface OperatorRoleRepository extends JpaRepository<OperatorRole, Long> {

	int findByOperatorId(int operatorId);
	
}
