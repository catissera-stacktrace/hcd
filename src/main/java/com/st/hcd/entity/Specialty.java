package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Specialty.findAll", query="SELECT s FROM Specialty s")
public class Specialty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to Examinationtype
	@OneToMany(mappedBy="specialty")
	private List<ExaminationType> examinationtypes;

	//bi-directional many-to-one association to Professionalhasspecialty
	@OneToMany(mappedBy="specialty")
	private List<ProfessionalHasSpecialty> professionalhasspecialties;

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

	public List<ExaminationType> getExaminationtypes() {
		return this.examinationtypes;
	}

	public void setExaminationtypes(List<ExaminationType> examinationtypes) {
		this.examinationtypes = examinationtypes;
	}

	public ExaminationType addExaminationtype(ExaminationType examinationtype) {
		getExaminationtypes().add(examinationtype);
		examinationtype.setSpecialty(this);

		return examinationtype;
	}

	public ExaminationType removeExaminationtype(ExaminationType examinationtype) {
		getExaminationtypes().remove(examinationtype);
		examinationtype.setSpecialty(null);

		return examinationtype;
	}

	public List<ProfessionalHasSpecialty> getProfessionalhasspecialties() {
		return this.professionalhasspecialties;
	}

	public void setProfessionalhasspecialties(List<ProfessionalHasSpecialty> professionalhasspecialties) {
		this.professionalhasspecialties = professionalhasspecialties;
	}

	public ProfessionalHasSpecialty addProfessionalhasspecialty(ProfessionalHasSpecialty professionalhasspecialty) {
		getProfessionalhasspecialties().add(professionalhasspecialty);
		professionalhasspecialty.setSpecialty(this);

		return professionalhasspecialty;
	}

	public ProfessionalHasSpecialty removeProfessionalhasspecialty(ProfessionalHasSpecialty professionalhasspecialty) {
		getProfessionalhasspecialties().remove(professionalhasspecialty);
		professionalhasspecialty.setSpecialty(null);

		return professionalhasspecialty;
	}

}