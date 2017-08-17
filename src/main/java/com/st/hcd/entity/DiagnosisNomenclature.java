package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the diagnosisnomenclature database table.
 * 
 */
@Entity
@NamedQuery(name="DiagnosisNomenclature.findAll", query="SELECT d FROM DiagnosisNomenclature d")
public class DiagnosisNomenclature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String code;

	private String description;

	private String status;

	//bi-directional many-to-one association to Diagnosi
	@OneToMany(mappedBy="diagnosisnomenclature")
	private List<Diagnosi> diagnosis;

	public DiagnosisNomenclature() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Diagnosi> getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(List<Diagnosi> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Diagnosi addDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().add(diagnosi);
		diagnosi.setDiagnosisnomenclature(this);

		return diagnosi;
	}

	public Diagnosi removeDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().remove(diagnosi);
		diagnosi.setDiagnosisnomenclature(null);

		return diagnosi;
	}

}