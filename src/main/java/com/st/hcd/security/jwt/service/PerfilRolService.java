package com.st.hcd.security.jwt.service;

import java.util.List;

import com.st.hcd.security.jwt.entity.PerfilRol;

public interface PerfilRolService {

	List<PerfilRol> getPerfilRoles();
	
	PerfilRol findByPerfilId(Integer perfilId);
	
	PerfilRol findByRolId(Integer rolId);
}
