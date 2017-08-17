package com.st.hcd.security.jwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.st.hcd.security.jwt.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	List<Rol> findAll();

	Rol findById(int id);
}
