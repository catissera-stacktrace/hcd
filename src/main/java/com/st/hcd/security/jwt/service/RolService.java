package com.st.hcd.security.jwt.service;

import java.util.List;

import com.st.hcd.security.jwt.entity.Rol;

public interface RolService {

	List<Rol> getRoles();
	
	Rol findById(Integer id);
	
	void deleteById(Integer id);
	
}
