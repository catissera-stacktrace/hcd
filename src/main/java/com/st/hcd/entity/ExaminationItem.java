package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="ExaminationItem.findAll", query="SELECT e FROM ExaminationItem e")
public class ExaminationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to Examinationtype
	@ManyToOne
	@JoinColumn(name="examinationTypeId")
	private ExaminationType examinationtype;

	//bi-directional many-to-one association to Examinationvalue
	@OneToMany(mappedBy="examinationitem")
	private List<ExaminationValue> examinationvalues;

	public ExaminationItem() {
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

	public ExaminationType getExaminationtype() {
		return this.examinationtype;
	}

	public void setExaminationtype(ExaminationType examinationtype) {
		this.examinationtype = examinationtype;
	}

	public List<ExaminationValue> getExaminationvalues() {
		return this.examinationvalues;
	}

	public void setExaminationvalues(List<ExaminationValue> examinationvalues) {
		this.examinationvalues = examinationvalues;
	}

	public ExaminationValue addExaminationvalue(ExaminationValue examinationvalue) {
		getExaminationvalues().add(examinationvalue);
		examinationvalue.setExaminationitem(this);

		return examinationvalue;
	}

	public ExaminationValue removeExaminationvalue(ExaminationValue examinationvalue) {
		getExaminationvalues().remove(examinationvalue);
		examinationvalue.setExaminationitem(null);

		return examinationvalue;
	}

}