package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@NamedQuery(name="ProfessionalHasSpecialty.findAll", query="SELECT p FROM ProfessionalHasSpecialty p")
public class ProfessionalHasSpecialty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Integer professionalId;
	
	public Integer getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(Integer professionalId) {
		this.professionalId = professionalId;
	}

	//bi-directional many-to-one association to Professional
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="professionalId", insertable=false, updatable=false)
	@JsonBackReference(value="professional-professionalhasspecialties")
	private Professional professional;

	//bi-directional many-to-one association to Specialty
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="specialtyId", insertable=false, updatable=false)
	@JsonBackReference(value="specialty-professionalhasspecialties")
	private Specialty specialty;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	public Specialty getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

}