package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="examinationvalues")
@NamedQuery(name="ExaminationValue.findAll", query="SELECT e FROM ExaminationValue e")
public class ExaminationValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	private String examValue;

	private int modifiedBy;

	//bi-directional many-to-one association to Consultation
	@ManyToOne
	@JoinColumn(name="consultationId")
	private Consultation consultation;

	//bi-directional many-to-one association to Examinationitem
	@ManyToOne
	@JoinColumn(name="analyzedItemsId")
	private ExaminationItem examinationitem;

	public ExaminationValue() {
	}

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

	public String getExamValue() {
		return this.examValue;
	}

	public void setExamValue(String examValue) {
		this.examValue = examValue;
	}

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Consultation getConsultation() {
		return this.consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public ExaminationItem getExaminationitem() {
		return this.examinationitem;
	}

	public void setExaminationitem(ExaminationItem examinationitem) {
		this.examinationitem = examinationitem;
	}

}