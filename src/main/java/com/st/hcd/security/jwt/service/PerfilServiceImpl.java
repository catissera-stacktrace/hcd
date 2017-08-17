package com.st.hcd.security.jwt.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.security.jwt.entity.Perfil;
import com.st.hcd.security.jwt.repository.PerfilRepository;


@Service
public class PerfilServiceImpl implements PerfilService {

	@Resource 
	PerfilRepository perfilRepository;
	
	@Override
	public List<Perfil> getPerfiles() {
		return perfilRepository.findAll();
	}

	@Override
	public Perfil findById(Integer id) {
		return perfilRepository.findById(id);
	}


	@Override
	public void deleteById(Integer id) {
		perfilRepository.delete(id);
	}

}
