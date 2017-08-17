package com.st.hcd.security.jwt.service;

import java.util.List;

import com.st.hcd.security.jwt.entity.PerfilOperator;

public interface PerfilOperatorService {

	List<PerfilOperator> getPerfilOperators();
	
	PerfilOperator findByPerfilOperatorId(int operatorId);
	
}
