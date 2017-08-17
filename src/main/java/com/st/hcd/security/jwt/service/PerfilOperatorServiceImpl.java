package com.st.hcd.security.jwt.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.security.jwt.entity.PerfilOperator;
import com.st.hcd.security.jwt.repository.PerfilOperatorRepository;


@Service
public class PerfilOperatorServiceImpl implements PerfilOperatorService {

	@Resource 
	PerfilOperatorRepository perfilOperatorRepository;
	
	@Override
	public List<PerfilOperator> getPerfilOperators() {
		return perfilOperatorRepository.findAll();
	}

	@Override
	public PerfilOperator findByPerfilOperatorId(int operatorId) {
		return perfilOperatorRepository.findByOperatorId(operatorId);
	}

}
