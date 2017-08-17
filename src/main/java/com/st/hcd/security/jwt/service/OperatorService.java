package com.st.hcd.security.jwt.service;

import java.util.List;

import com.st.hcd.security.jwt.entity.Operator;

public interface OperatorService {

	List<Operator> getOperators();
	
	Operator findByOperatorId(Integer operatorId);
	
	List<Operator> findByEmail(String email);
}
