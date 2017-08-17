package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the surgery database table.
 * 
 */
@Entity
@NamedQuery(name="Surgery.findAll", query="SELECT s FROM Surgery s")
public class Surgery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	private Integer serviceId;
	
	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="surgeryId")
	@JsonManagedReference(value="surgery-schedule")
	private List<Schedule> schedules;

	//bi-directional many-to-one association to Service
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="serviceId", insertable=false, updatable=false)
	@JsonBackReference(value="service-surgery")
	private Services service;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setSurgery(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setSurgery(null);

		return schedule;
	}

	public Services getService() {
		return this.service;
	}

	public void setService(Services service) {
		this.service = service;
	}

}