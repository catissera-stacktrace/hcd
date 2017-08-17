package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the consultation database table.
 * 
 */
@Entity
@NamedQuery(name="Consultation.findAll", query="SELECT c FROM Consultation c")
public class Consultation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String addictions;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;

	private Integer bloodPressure;

	private Integer bodyMass;

	private Integer breathingFrecuency;

	private Integer createdBy;
	
	private Integer scheduleId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	private String familyBackground;

	private Integer heartRate;

	private Integer height;

	private Integer modifiedBy;

	private String previousTreatment;

	private String reason;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	private String symptom;

	private Integer temperature;

	private Integer weight;

	//bi-directional many-to-one association to Schedule
	@JoinColumn(name="scheduleId", insertable=false, updatable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference(value="schedule-consultation")
	private Schedule schedule;

	//bi-directional many-to-one association to Diagnosi
	@OneToMany(mappedBy="consultation")
	private List<Diagnosi> diagnosis;

	//bi-directional many-to-one association to Examinationvalue
	@OneToMany(mappedBy="consultation")
	private List<ExaminationValue> examinationvalues;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="consultation")
	private List<Prescription> prescriptions;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddictions() {
		return this.addictions;
	}

	public void setAddictions(String addictions) {
		this.addictions = addictions;
	}

	public Date getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getBloodPressure() {
		return this.bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public int getBodyMass() {
		return this.bodyMass;
	}

	public void setBodyMass(int bodyMass) {
		this.bodyMass = bodyMass;
	}

	public int getBreathingFrecuency() {
		return this.breathingFrecuency;
	}

	public void setBreathingFrecuency(int breathingFrecuency) {
		this.breathingFrecuency = breathingFrecuency;
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

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFamilyBackground() {
		return this.familyBackground;
	}

	public void setFamilyBackground(String familyBackground) {
		this.familyBackground = familyBackground;
	}

	public int getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getPreviousTreatment() {
		return this.previousTreatment;
	}

	public void setPreviousTreatment(String previousTreatment) {
		this.previousTreatment = previousTreatment;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Diagnosi> getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(List<Diagnosi> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Diagnosi addDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().add(diagnosi);
		diagnosi.setConsultation(this);

		return diagnosi;
	}

	public Diagnosi removeDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().remove(diagnosi);
		diagnosi.setConsultation(null);

		return diagnosi;
	}

	public List<ExaminationValue> getExaminationvalues() {
		return this.examinationvalues;
	}

	public void setExaminationvalues(List<ExaminationValue> examinationvalues) {
		this.examinationvalues = examinationvalues;
	}

	public ExaminationValue addExaminationvalue(ExaminationValue examinationvalue) {
		getExaminationvalues().add(examinationvalue);
		examinationvalue.setConsultation(this);

		return examinationvalue;
	}

	public ExaminationValue removeExaminationvalue(ExaminationValue examinationvalue) {
		getExaminationvalues().remove(examinationvalue);
		examinationvalue.setConsultation(null);

		return examinationvalue;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setConsultation(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setConsultation(null);

		return prescription;
	}

}