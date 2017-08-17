package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="MedicalInsurance.findAll", query="SELECT m FROM MedicalInsurance m")
public class MedicalInsurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to Medicalinsuranceplan
	@OneToMany(mappedBy="medicalinsurance")
	private List<MedicalInsurancePlan> medicalinsuranceplans;

	public MedicalInsurance() {
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

	public List<MedicalInsurancePlan> getMedicalinsuranceplans() {
		return this.medicalinsuranceplans;
	}

	public void setMedicalinsuranceplans(List<MedicalInsurancePlan> medicalinsuranceplans) {
		this.medicalinsuranceplans = medicalinsuranceplans;
	}

	public MedicalInsurancePlan addMedicalinsuranceplan(MedicalInsurancePlan medicalinsuranceplan) {
		getMedicalinsuranceplans().add(medicalinsuranceplan);
		medicalinsuranceplan.setMedicalinsurance(this);

		return medicalinsuranceplan;
	}

	public MedicalInsurancePlan removeMedicalinsuranceplan(MedicalInsurancePlan medicalinsuranceplan) {
		getMedicalinsuranceplans().remove(medicalinsuranceplan);
		medicalinsuranceplan.setMedicalinsurance(null);

		return medicalinsuranceplan;
	}

}