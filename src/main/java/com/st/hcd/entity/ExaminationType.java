package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="ExaminationType.findAll", query="SELECT e FROM ExaminationType e")
public class ExaminationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Examinationitem
	@OneToMany(mappedBy="examinationtype")
	private List<ExaminationItem> examinationitems;

	//bi-directional many-to-one association to Specialty
	@ManyToOne
	@JoinColumn(name="specialtyId")
	private Specialty specialty;

	public ExaminationType() {
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

	public List<ExaminationItem> getExaminationitems() {
		return this.examinationitems;
	}

	public void setExaminationitems(List<ExaminationItem> examinationitems) {
		this.examinationitems = examinationitems;
	}

	public ExaminationItem addExaminationitem(ExaminationItem examinationitem) {
		getExaminationitems().add(examinationitem);
		examinationitem.setExaminationtype(this);

		return examinationitem;
	}

	public ExaminationItem removeExaminationitem(ExaminationItem examinationitem) {
		getExaminationitems().remove(examinationitem);
		examinationitem.setExaminationtype(null);

		return examinationitem;
	}

	public Specialty getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

}