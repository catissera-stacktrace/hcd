package com.st.hcd.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.Person;
import com.st.hcd.entity.Schedule;
import com.st.hcd.service.PersonService;
import com.st.hcd.service.ScheduleService;

@RestController
@RequestMapping("/secure")
public class PersonController {

	@Resource
	ScheduleService scheduleService;
	
	@Resource
	PersonService personService;

	@RequestMapping(value = "/person/scheduleddate/{personId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Person getPersonByIdScheduledDate(@PathVariable Integer personId) throws ParseException {

		Person person = personService.getPersonById(personId);
		Integer perId = person.getId();

		DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date scheduledDateFrom = sourceFormat.parse("01-09-2017");
		Date scheduledDateTo   = sourceFormat.parse("05-09-2017");

		//List<Schedule> schedules = scheduleService.getSchedulesByte(personId);		
		List<Schedule> schedules = scheduleService.getSchedulesByDateByPerson(scheduledDateFrom, scheduledDateTo, perId);
		
		person.setSchedules(schedules);

		return person;
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Person getPersonByIdBy(@PathVariable Integer personId) throws ParseException {

		return personService.getPersonById(personId);
	}
	

	@RequestMapping(value = "/person", method = RequestMethod.PUT, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Person updatePerson(@RequestBody Person person) {
		
		return personService.updatePerson(person);
	}
	
}
