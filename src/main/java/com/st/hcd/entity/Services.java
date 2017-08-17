package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Services.findAll", query="SELECT s FROM Services s")
public class Services implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@JsonIgnore
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dateModified;

	private int duration;
	@JsonIgnore
	private Integer modifiedBy;

	private String name;

	private String phone;

	private String status;

	private String typeService;

	private Integer healthCenterId;
	
	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="serviceId")
	@JsonManagedReference(value="service-schedule")
	private List<Schedule> schedules;


	//bi-directional many-to-one association to Healthcenter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="healthCenterId", insertable=false, updatable=false)
	@JsonBackReference(value="healthcenter-service")
	private HealthCenter healthcenter;

	//bi-directional many-to-one association to Servicehasoperator
	//@OneToMany(mappedBy="serviceId")
	//private List<ServiceHasOperator> servicehasoperators;

	//bi-directional many-to-one association to Servicehasprofessional
	@OneToMany(mappedBy="serviceId")
	@JsonManagedReference(value="service-servicehasprofessionals")
	private List<ServiceHasProfessional> servicehasprofessionals;

	//bi-directional many-to-one association to Surgery
	@OneToMany(mappedBy="serviceId")
	@JsonManagedReference(value="service-surgery")
	private List<Surgery> surgeries;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeService() {
		return this.typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setService(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setService(null);

		return schedule;
	}

//	public HealthCenter getHealthcenter() {
//		return this.healthcenter;
//	}
//
//	public void setHealthcenter(HealthCenter healthcenter) {
//		this.healthcenter = healthcenter;
//	}

//	public List<ServiceHasOperator> getServicehasoperators() {
//		return this.servicehasoperators;
//	}
//
//	public void setServicehasoperators(List<ServiceHasOperator> servicehasoperators) {
//		this.servicehasoperators = servicehasoperators;
//	}

	public List<ServiceHasProfessional> getServicehasprofessionals() {
		return this.servicehasprofessionals;
	}

	public void setServicehasprofessionals(List<ServiceHasProfessional> servicehasprofessionals) {
		this.servicehasprofessionals = servicehasprofessionals;
	}

	public ServiceHasProfessional addServicehasprofessional(ServiceHasProfessional servicehasprofessional) {
		getServicehasprofessionals().add(servicehasprofessional);
		servicehasprofessional.setService(this);

		return servicehasprofessional;
	}

	public ServiceHasProfessional removeServicehasprofessional(ServiceHasProfessional servicehasprofessional) {
		getServicehasprofessionals().remove(servicehasprofessional);
		servicehasprofessional.setService(null);

		return servicehasprofessional;
	}

	public List<Surgery> getSurgeries() {
		return this.surgeries;
	}

	public void setSurgeries(List<Surgery> surgeries) {
		this.surgeries = surgeries;
	}
}