package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="MedicalInsurancePlan.findAll", query="SELECT m FROM MedicalInsurancePlan m")
public class MedicalInsurancePlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Medicalinsurance
	@ManyToOne
	@JoinColumn(name="medicalInsuranceId")
	private MedicalInsurance medicalinsurance;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="medicalinsuranceplan")
	private List<Person> persons;

	public MedicalInsurancePlan() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MedicalInsurance getMedicalinsurance() {
		return this.medicalinsurance;
	}

	public void setMedicalinsurance(MedicalInsurance medicalinsurance) {
		this.medicalinsurance = medicalinsurance;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setMedicalinsuranceplan(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setMedicalinsuranceplan(null);

		return person;
	}

}