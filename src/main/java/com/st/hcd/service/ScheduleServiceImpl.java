package com.st.hcd.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.st.hcd.entity.Schedule;
import com.st.hcd.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl  implements ScheduleService {

	@Resource 
	ScheduleRepository scheduleRepository;
	
	@Override
	public Schedule getScheduleById(Integer scheduleId) {
		return scheduleRepository.findScheduleById(scheduleId);
	}

	@Override
	public List<Schedule> getSchedulesByDate(Date scheduledDateFrom, Date scheduledDateTo) {
		return scheduleRepository.findSchedulesByDate(scheduledDateFrom, scheduledDateTo);
	}

	@Override
	public List<Schedule> getSchedulesByDateByPerson(Date scheduledDateFrom, Date scheduledDateTo, Integer personId) {
		return scheduleRepository.findSchedulesByDateByPerson(scheduledDateFrom, scheduledDateTo, personId);
	}
	
	@Override
	public Integer deleteScheduleById(Integer scheduleId) {
		return scheduleRepository.deleteScheduleById(scheduleId);
	}

	@Override
	public Schedule updateSchedule(Schedule schedule, String subject) {
		
		Schedule oldSchedule = scheduleRepository.findOne(schedule.getId());
		
		if(oldSchedule != null) {
			schedule.setDateCreated(oldSchedule.getDateCreated());
			schedule.setCreatedBy(oldSchedule.getCreatedBy());
			schedule.setServiceId(oldSchedule.getServiceId());
			schedule.setDateModified( new Date());			
		}
		else {
			schedule.setDateCreated(new Date());
		}
		
		return scheduleRepository.save(schedule);
		
	}


}

