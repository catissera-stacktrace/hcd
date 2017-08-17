package com.st.hcd.service;

import com.st.hcd.entity.Person;

public interface PersonService {
	
	Person getPersonById(Integer personId);

	Person getPersonByEmail(String email);
	
	Person updatePerson(Person person);
}
