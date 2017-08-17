package com.st.hcd.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.st.hcd.security.jwt.entity.PerfilRol;

@Repository
public interface PerfilRolRepository extends JpaRepository<PerfilRol, Long> {

	PerfilRol findByRolId(int operatorId);
	
	PerfilRol findByPerfilId(int perfilId);
	
}
