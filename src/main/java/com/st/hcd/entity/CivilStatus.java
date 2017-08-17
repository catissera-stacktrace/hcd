package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the civilstatus database table.
 * 
 */
@Entity
@NamedQuery(name="CivilStatus.findAll", query="SELECT c FROM CivilStatus c")
public class CivilStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="civilStatusId")
	@JsonManagedReference(value="civilStatus-person")
	private List<Person> persons;

	public CivilStatus() {
	}

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

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setCivilstatus(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setCivilstatus(null);

		return person;
	}

}