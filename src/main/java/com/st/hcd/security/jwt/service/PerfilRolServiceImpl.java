package com.st.hcd.security.jwt.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.security.jwt.entity.PerfilRol;
import com.st.hcd.security.jwt.repository.PerfilRolRepository;


@Service
public class PerfilRolServiceImpl implements PerfilRolService {

	@Resource 
	PerfilRolRepository perfilRolRepository;
	
	@Override
	public List<PerfilRol> getPerfilRoles() {
		return perfilRolRepository.findAll();
	}

	@Override
	public PerfilRol findByPerfilId(Integer perfilId) {
		return perfilRolRepository.findByPerfilId(perfilId);
	}

	@Override
	public PerfilRol findByRolId(Integer rolId) {
		return perfilRolRepository.findByRolId(rolId);
	}

}
