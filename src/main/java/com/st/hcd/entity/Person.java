package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.st.hcd.security.jwt.entity.Operator;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String addressNumber;

	private String allergies;

	@Temporal(TemporalType.DATE)
	private Date birthDay;

	private int birthWeight;

	private String bloodType;

	@JsonIgnore
	private int createdBy;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfDeath;

	private int docNumber;

	@JsonIgnore
	private String email;

	private String firstName;

	private String insurancePlanNumber;

	private String lastName;

	@JsonIgnore
	private int modifiedBy;

	private String neighborhood;

	private String normalBirth;

	private String phone;

	private String photo;

	private String postalCode;

	private String reasonForDeath;

	private String sex;

	private byte[] signature;

	private String street;

	private Integer documentTypeId;
	
	private Integer civilStatusId;
	
	public Integer getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(Integer documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public Integer getCivilStatusId() {
		return civilStatusId;
	}

	public void setCivilStatusId(Integer civilStatusId) {
		this.civilStatusId = civilStatusId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	private Integer cityId;

	//bi-directional many-to-one association to Operator
	@OneToMany(mappedBy="personId")
	@JsonManagedReference(value="person-operator")
	private List<Operator> operators;

	
	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fatherId")
	private Person person1;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="fatherId")
	private List<Person> persons1;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="motherId")
	private Person person2;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="motherId")
	private List<Person> persons2;

	
	//bi-directional many-to-one association to Civilstatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="civilStatusId", insertable=false, updatable=false)
	@JsonBackReference(value="civilstatus-person")
	private CivilStatus civilstatus;

	//bi-directional many-to-one association to Documenttype
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="documentTypeId", insertable=false, updatable=false)
	@JsonBackReference(value="documenttype-person")
	private DocumentType documentType;

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	//bi-directional many-to-one association to Medicalinsuranceplan
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="insurancePlanId")
	@JsonBackReference(value="medicalinsuranceplan-person")
	private MedicalInsurancePlan medicalinsuranceplan;

	//bi-directional many-to-one association to City
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cityId", insertable=false, updatable=false)
	@JsonBackReference(value="city-person")
	private City city;

	//bi-directional many-to-one association to Professional
	@OneToMany(mappedBy="personId")
	@JsonManagedReference(value="person-professional")
	private List<Professional> professionals;

	//bi-directional many-to-one association to Schedule
	@JsonIgnore
	@OneToMany(mappedBy="personId")
	@JsonManagedReference(value="person-schedule")
	private List<Schedule> schedules;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressNumber() {
		return this.addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAllergies() {
		return this.allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public int getBirthWeight() {
		return this.birthWeight;
	}

	public void setBirthWeight(int birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
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

	public Date getDateOfDeath() {
		return this.dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public int getDocNumber() {
		return this.docNumber;
	}

	public void setDocNumber(int docNumber) {
		this.docNumber = docNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInsurancePlanNumber() {
		return this.insurancePlanNumber;
	}

	public void setInsurancePlanNumber(String insurancePlanNumber) {
		this.insurancePlanNumber = insurancePlanNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getNeighborhood() {
		return this.neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getNormalBirth() {
		return this.normalBirth;
	}

	public void setNormalBirth(String normalBirth) {
		this.normalBirth = normalBirth;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getReasonForDeath() {
		return this.reasonForDeath;
	}

	public void setReasonForDeath(String reasonForDeath) {
		this.reasonForDeath = reasonForDeath;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public byte[] getSignature() {
		return this.signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Operator> getOperators() {
		return this.operators;
	}

	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}

	public Person getPerson1() {
		return this.person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public List<Person> getPersons1() {
		return this.persons1;
	}

	public void setPersons1(List<Person> persons1) {
		this.persons1 = persons1;
	}

	public Person addPersons1(Person persons1) {
		getPersons1().add(persons1);
		persons1.setPerson1(this);

		return persons1;
	}

	public Person removePersons1(Person persons1) {
		getPersons1().remove(persons1);
		persons1.setPerson1(null);

		return persons1;
	}

	public Person getPerson2() {
		return this.person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public List<Person> getPersons2() {
		return this.persons2;
	}

	public void setPersons2(List<Person> persons2) {
		this.persons2 = persons2;
	}

	public Person addPersons2(Person persons2) {
		getPersons2().add(persons2);
		persons2.setPerson2(this);

		return persons2;
	}

	public Person removePersons2(Person persons2) {
		getPersons2().remove(persons2);
		persons2.setPerson2(null);

		return persons2;
	}

	public CivilStatus getCivilstatus() {
		return this.civilstatus;
	}

	public void setCivilstatus(CivilStatus civilstatus) {
		this.civilstatus = civilstatus;
	}

	public DocumentType getDocumenttype() {
		return this.documentType;
	}

	public void setDocumenttype(DocumentType documentType) {
		this.documentType = documentType;
	}

	public MedicalInsurancePlan getMedicalinsuranceplan() {
		return this.medicalinsuranceplan;
	}

	public void setMedicalinsuranceplan(MedicalInsurancePlan medicalinsuranceplan) {
		this.medicalinsuranceplan = medicalinsuranceplan;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Professional> getProfessionals() {
		return this.professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}

	public Professional addProfessional(Professional professional) {
		getProfessionals().add(professional);
		professional.setPerson(this);

		return professional;
	}

	public Professional removeProfessional(Professional professional) {
		getProfessionals().remove(professional);
		professional.setPerson(null);

		return professional;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setPerson(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setPerson(null);

		return schedule;
	}

}