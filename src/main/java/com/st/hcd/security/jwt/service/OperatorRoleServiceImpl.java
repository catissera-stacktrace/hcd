package com.st.hcd.security.jwt.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.security.jwt.entity.OperatorRole;
import com.st.hcd.security.jwt.repository.OperatorRoleRepository;


@Service
public class OperatorRoleServiceImpl implements OperatorRoleService {

	@Resource 
	OperatorRoleRepository operatorRoleRepository;
	
	@Override
	public List<OperatorRole> getOperatorRoles() {
		return operatorRoleRepository.findAll();
	}

	@Override
	public OperatorRole findByOperatorId(Long operatorId) {
		return operatorRoleRepository.findOne(operatorId) ;
	}

}
