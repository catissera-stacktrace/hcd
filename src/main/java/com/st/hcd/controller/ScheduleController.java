package com.st.hcd.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.st.hcd.entity.Schedule;
import com.st.hcd.security.jwt.token.util.TokenExtractor;
import com.st.hcd.service.ScheduleService;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/secure")
public class ScheduleController {

	@Resource
	ScheduleService scheduleService;

	@RequestMapping(value = "/schedule/{scheduleId}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Schedule getScheduleById(@PathVariable Integer scheduleId, HttpServletRequest request) {
		
		Schedule schedule = scheduleService.getScheduleById(scheduleId);
		return schedule;
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public List<Schedule> getSchedulesByDate( @RequestParam("dateFrom") String dateFrom
			                                , @RequestParam("dateTo") String dateTo) throws ParseException {

		DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date scheduledDateFrom = sourceFormat.parse(dateFrom);
		Date scheduledDateTo   = sourceFormat.parse(dateTo);;
		
		return scheduleService.getSchedulesByDate(scheduledDateFrom, scheduledDateTo);
	}
	
	@RequestMapping(value = "/schedule/{scheduleId}", method = RequestMethod.DELETE, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Integer deleteScheduleById(@PathVariable Integer scheduleId, HttpServletRequest request) {
		
		return scheduleService.deleteScheduleById(scheduleId);
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.PUT, produces={ MediaType.APPLICATION_JSON_VALUE })
	public Schedule updateScheduleById(@RequestBody Schedule schedule, HttpServletRequest request) {
		
		String subject = getSubjectByToken(request);
		
		return scheduleService.updateSchedule(schedule, subject);
	}

	public String getSubjectByToken(HttpServletRequest request) {
		
		String header = request.getHeader("X-Authorization");
		String token = header.substring(7); 
		Claims claims = TokenExtractor.extractClaims(token);	
		String subject = claims.getSubject();
		
		return subject;
		
	}
	
}
