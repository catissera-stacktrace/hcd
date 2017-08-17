package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Professional.findAll", query="SELECT p FROM Professional p")
public class Professional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	private String matricula;

	private Integer modifiedBy;
	
	private Integer personId;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}
	
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	private String status;

	@Temporal(TemporalType.DATE)
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	private Date validTo;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference(value="person-professional")
	@JoinColumn(name="personId", insertable=false, updatable=false)
	private Person person;

	//bi-directional many-to-one association to Professionalhasspecialty
	@OneToMany(mappedBy="professionalId")
	@JsonManagedReference(value="professional-professionalhasspecialties")
	private List<ProfessionalHasSpecialty> professionalhasspecialties;

	//bi-directional many-to-one association to Schedule
//	@OneToMany(mappedBy="professionalId")
//	@JsonIgnore	
//	@JsonManagedReference(value="professional-schedule")
	@Transient
	private List<Schedule> schedules;

	//bi-directional many-to-one association to Servicehasprofessional
	@OneToMany(mappedBy="professionalId")
	@JsonManagedReference(value="professional-servicehasprofessionals")
	private List<ServiceHasProfessional> servicehasprofessionals;

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

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<ProfessionalHasSpecialty> getProfessionalhasspecialties() {
		return this.professionalhasspecialties;
	}

	public void setProfessionalhasspecialties(List<ProfessionalHasSpecialty> professionalhasspecialties) {
		this.professionalhasspecialties = professionalhasspecialties;
	}

	public ProfessionalHasSpecialty addProfessionalhasspecialty(ProfessionalHasSpecialty professionalhasspecialty) {
		getProfessionalhasspecialties().add(professionalhasspecialty);
		professionalhasspecialty.setProfessional(this);

		return professionalhasspecialty;
	}

	public ProfessionalHasSpecialty removeProfessionalhasspecialty(ProfessionalHasSpecialty professionalhasspecialty) {
		getProfessionalhasspecialties().remove(professionalhasspecialty);
		professionalhasspecialty.setProfessional(null);

		return professionalhasspecialty;
	}

//	public List<Schedule> getSchedules() {
//		return this.schedules;
//	}
//
//	public void setSchedules(List<Schedule> schedules) {
//		this.schedules = schedules;
//	}

	public List<ServiceHasProfessional> getServicehasprofessionals() {
		return this.servicehasprofessionals;
	}

	public void setServicehasprofessionals(List<ServiceHasProfessional> servicehasprofessionals) {
		this.servicehasprofessionals = servicehasprofessionals;
	}

	public ServiceHasProfessional addServicehasprofessional(ServiceHasProfessional servicehasprofessional) {
		getServicehasprofessionals().add(servicehasprofessional);
		servicehasprofessional.setProfessional(this);

		return servicehasprofessional;
	}

	public ServiceHasProfessional removeServicehasprofessional(ServiceHasProfessional servicehasprofessional) {
		getServicehasprofessionals().remove(servicehasprofessional);
		servicehasprofessional.setProfessional(null);

		return servicehasprofessional;
	}

}