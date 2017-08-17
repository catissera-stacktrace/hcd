package com.st.hcd.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.st.hcd.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	@Query("SELECT s FROM Schedule s where s.id = ?")
	Schedule findScheduleById(Integer scheduleId);

//	@Query("SELECT s FROM Schedule s where  where s.status = 'ACT' and s.id = ?")
//	Schedule findScheduleActiveById(Integer scheduleId);
	
	@Modifying
	@Transactional
	@Query("UPDATE Schedule AS s SET s.status = 'BAJ' where s.id = ?")
	Integer deleteScheduleById(Integer scheduleId);

	@Query("SELECT s FROM Schedule s WHERE s.schedulledDay BETWEEN ? AND ?")
	List<Schedule> findSchedulesByDate(Date scheduledDateFrom, Date scheduledDateTo);

	@Query("SELECT s FROM Schedule s WHERE s.schedulledDay BETWEEN ? AND ? AND s.personId = ?")
	List<Schedule> findSchedulesByDateByPerson(Date scheduledDateFrom, Date scheduledDateTo, Integer personId);
	
}

