package com.st.hcd.security.jwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.st.hcd.security.jwt.entity.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

	List<Perfil> findAll();

	Perfil findById(Integer id);
}
