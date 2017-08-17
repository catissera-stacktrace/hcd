package com.st.hcd.service;

import java.util.Date;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.entity.Person;
import com.st.hcd.entity.Schedule;
import com.st.hcd.repository.PersonRepository;

@Service
public class PersonServiceImpl  implements PersonService {

	@Resource 
	PersonRepository personRepository;

	@Override
	public Person getPersonByEmail(String email) {
		return personRepository.findPersonByEmail(email);
	}

	@Override
	public Person getPersonById(Integer personId) {
		return personRepository.findPersonById(personId);
	}

	@Override
	public Person updatePerson(Person person) {
		Person oldPerson = personRepository.findOne(person.getId());
		
		if(oldPerson != null) {
			person.setDateCreated(oldPerson.getDateCreated());
			person.setCreatedBy(oldPerson.getCreatedBy());
			person.setDateModified(new Date());
		}
		else {
			person.setDateCreated(new Date());
		}
		
		return personRepository.save(person);
	}

}

