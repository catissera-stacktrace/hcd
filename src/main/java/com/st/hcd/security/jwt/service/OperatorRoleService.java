package com.st.hcd.security.jwt.service;

import java.util.List;

import com.st.hcd.security.jwt.entity.OperatorRole;

public interface OperatorRoleService {

	List<OperatorRole> getOperatorRoles();
	
	OperatorRole findByOperatorId(Long operatorId);
	
}
