package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@NamedQuery(name="HealthCenter.findAll", query="SELECT h FROM HealthCenter h")
public class HealthCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String address;

	@Column(name="name")
	private String name;

	private String phone;

	//bi-directional many-to-one association to Perfil
	//@OneToMany(mappedBy="healthCenterId")
	//private List<Perfil> perfils;

	//bi-directional many-to-one association to Service
	@OneToMany(mappedBy="healthCenterId")
	@JsonManagedReference(value="healthcenter-service")
	private List<Services> services;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Services> getServices() {
		return this.services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}
}