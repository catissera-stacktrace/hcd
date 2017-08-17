package com.st.hcd.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.st.hcd.security.jwt.entity.Operator;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	private String endTime;

	private Boolean interConsult;

	private Integer modifiedBy;
	
	private Integer createdBy;
	
	private Integer serviceId;

	private Integer surgeryId;
	
	private Boolean overSchedule;

	private Boolean scheduledType;

	@Temporal(TemporalType.DATE)
	private Date schedulledDay;

	private String startTime;
	
	private Integer professionalId;
	
	private Integer personId;

	public Integer getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(Integer professionalId) {
		this.professionalId = professionalId;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	private String status;

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getSurgeryId() {
		return surgeryId;
	}

	public void setSurgeryId(Integer surgeryId) {
		this.surgeryId = surgeryId;
	}

	//bi-directional many-to-one association to Consultation
	@OneToMany(mappedBy="scheduleId")
	@JsonManagedReference(value="schedule-consultation")
	private List<Consultation> consultations;
	
	//bi-directional many-to-one association to Operator
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="createdBy", insertable=false, updatable=false)
	@JsonBackReference(value="operator-schedule")
	private Operator operator;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personId", insertable=false, updatable=false)
	@JsonBackReference(value="person-schedule")
	private Person person;

	//bi-directional many-to-one association to Surgery
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="surgeryId", insertable=false, updatable=false)
	@JsonBackReference(value="surgery-schedule")
	private Surgery surgery;

	//bi-directional many-to-one association to Service
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="serviceId", insertable=false, updatable=false)
	@JsonBackReference(value="service-schedule")
	private Services service;

	//bi-directional many-to-one association to Professional
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="professionalId", insertable=false, updatable=false)
	@JsonIgnore
	@JsonBackReference(value="professional-schedule")
	private Professional professional;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		//if(endTime == null) endTime=0;
		this.endTime = endTime;
	}

	public Boolean getInterConsult() {
		return this.interConsult;
	}

	public void setInterConsult(Boolean interConsult) {
		this.interConsult = interConsult;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Boolean getOverSchedule() {
		return this.overSchedule;
	}

	public void setOverSchedule(Boolean overSchedule) {
		this.overSchedule = overSchedule;
	}

	public Boolean getScheduledType() {
		return this.scheduledType;
	}

	public void setScheduledType(Boolean scheduledType) {
		this.scheduledType = scheduledType;
	}

	public Date getSchedulledDay() {
		return this.schedulledDay;
	}

	public void setSchedulledDay(Date schedulledDay) {
		this.schedulledDay = schedulledDay;
	}

	public void setSchedulledDay(String schedulledDay) throws ParseException {
		DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sourceFormat.parse(schedulledDay);
		this.schedulledDay = date;
	}
	
	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Consultation> getConsultations() {
		return this.consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Consultation addConsultation(Consultation consultation) {
		getConsultations().add(consultation);
		consultation.setSchedule(this);

		return consultation;
	}

	public Consultation removeConsultation(Consultation consultation) {
		getConsultations().remove(consultation);
		consultation.setSchedule(null);

		return consultation;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Surgery getSurgery() {
		return this.surgery;
	}

	public void setSurgery(Surgery surgery) {
		this.surgery = surgery;
	}

	public Services getService() {
		return this.service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}