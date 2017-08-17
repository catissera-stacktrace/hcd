package com.st.hcd.security.jwt.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.st.hcd.entity.Person;
import com.st.hcd.repository.PersonRepository;
import com.st.hcd.security.jwt.entity.Operator;
import com.st.hcd.security.jwt.repository.OperatorRepository;


@Service
public class OperatorServiceImpl implements OperatorService {

	@Resource 
	PersonRepository personRepository;

	@Resource 
	OperatorRepository operatorRepository;
	
	@Override
	public List<Operator> getOperators() {
		return operatorRepository.findAll();
	}

	@Override
	public Operator findByOperatorId(Integer operatorId) {
		return operatorRepository.findOne(operatorId) ;
	}

	@Override
	public List<Operator> findByEmail(String email) {
		Person person = personRepository.findPersonByEmail(email);
		return operatorRepository.FindByPersonId(person.getId());
	}
}
