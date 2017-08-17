package com.st.hcd.service;

import java.util.Date;
import java.util.List;

import com.st.hcd.entity.Schedule;

public interface ScheduleService {
	
	Schedule getScheduleById(Integer scheduleId);
	
	Integer deleteScheduleById(Integer scheduleId);
	
	Schedule updateSchedule(Schedule schedule, String subject);

	List<Schedule> getSchedulesByDate(Date scheduledDateFrom, Date scheduledDateTo);

	List<Schedule> getSchedulesByDateByPerson(Date scheduledDateFrom, Date scheduledDateTo, Integer personId);
	
}
