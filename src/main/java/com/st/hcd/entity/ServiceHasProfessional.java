package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name="ServiceHasProfessional.findAll", query="SELECT s FROM ServiceHasProfessional s")
public class ServiceHasProfessional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Integer serviceId;
	
	private Integer professionalId;
	
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(Integer professionalId) {
		this.professionalId = professionalId;
	}

	//bi-directional many-to-one association to Service
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="serviceId", insertable=false, updatable=false)
	@JsonBackReference(value="service-servicehasprofessionals")
	private Services service;

	//bi-directional many-to-one association to Professional
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="professionalId", insertable=false, updatable=false)
	@JsonBackReference(value="professional-servicehasprofessionals")
	private Professional professional;

	public ServiceHasProfessional() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Services getService() {
		return this.service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}