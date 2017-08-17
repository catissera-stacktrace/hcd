package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the diagnosis database table.
 * 
 */
@Entity
@Table(name="diagnosis")
@NamedQuery(name="Diagnosi.findAll", query="SELECT d FROM Diagnosi d")
public class Diagnosi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	private String description;

	private String diagnosisType;

	private int modifiedBy;

	//bi-directional many-to-one association to Consultation
	@ManyToOne
	@JoinColumn(name="consultationId")
	private Consultation consultation;

	//bi-directional many-to-one association to Diagnosisnomenclature
	@ManyToOne
	@JoinColumn(name="diagnosisNomenclatureId")
	private DiagnosisNomenclature diagnosisnomenclature;

	public Diagnosi() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiagnosisType() {
		return this.diagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
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

	public DiagnosisNomenclature getDiagnosisnomenclature() {
		return this.diagnosisnomenclature;
	}

	public void setDiagnosisnomenclature(DiagnosisNomenclature diagnosisnomenclature) {
		this.diagnosisnomenclature = diagnosisnomenclature;
	}

}