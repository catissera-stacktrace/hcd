package com.st.hcd.security.jwt.service;

import java.util.List;

import com.st.hcd.security.jwt.entity.Perfil;

public interface PerfilService {

	List<Perfil> getPerfiles();
	
	Perfil findById(Integer id);
	
	void deleteById(Integer id);

}
