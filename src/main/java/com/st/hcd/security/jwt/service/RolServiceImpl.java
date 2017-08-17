package com.st.hcd.security.jwt.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.security.jwt.entity.Rol;
import com.st.hcd.security.jwt.repository.RolRepository;


@Service
public class RolServiceImpl implements RolService {

	@Resource 
	RolRepository rolRepository;
	
	@Override
	public List<Rol> getRoles() {
		return rolRepository.findAll();
	}

	@Override
	public Rol findById(Integer id) {
		return rolRepository.findById(id);
	}


	@Override
	public void deleteById(Integer id) {
		rolRepository.delete(id);
	}

}
