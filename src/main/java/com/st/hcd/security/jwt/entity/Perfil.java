package com.st.hcd.security.jwt.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.st.hcd.entity.HealthCenter;

import java.util.List;

@Entity
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	private int id;

	@JsonIgnore
	private String code;

	@JsonIgnore
	private String description;

	@JsonIgnore
	private String name;

	@JsonIgnore
	@Column(name="health_center_id")
	private Integer healthCenterId;
	
	//bi-directional many-to-one association to Healthcenter
	@Transient
	@ManyToOne
	@JoinColumn(name="healthCenterId", insertable=false, updatable=false)
	private HealthCenter healthcenter;
	
	//bi-directional many-to-one association to Perfiloperator
	//@OneToMany(mappedBy="perfil")
	//private List<PerfilOperator> perfiloperators;

	//bi-directional many-to-one association to Perfilrol
	@OneToMany(mappedBy="perfilId")
	private List<PerfilRol> perfilrols;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public HealthCenter getHealthcenter() {
//		return this.healthcenter;
//	}
//
//	public void setHealthcenter(HealthCenter healthcenter) {
//		this.healthcenter = healthcenter;
//	}

//	public List<PerfilOperator> getPerfiloperators() {
//		return this.perfiloperators;
//	}
//
//	public void setPerfiloperators(List<PerfilOperator> perfiloperators) {
//		this.perfiloperators = perfiloperators;
//	}

//	public PerfilOperator addPerfiloperator(PerfilOperator perfiloperator) {
//		getPerfiloperators().add(perfiloperator);
//		perfiloperator.setPerfil(this);
//
//		return perfiloperator;
//	}
//
//	public PerfilOperator removePerfiloperator(PerfilOperator perfiloperator) {
//		getPerfiloperators().remove(perfiloperator);
//		perfiloperator.setPerfil(null);
//
//		return perfiloperator;
//	}

	public List<PerfilRol> getPerfilrols() {
		return this.perfilrols;
	}

	public void setPerfilrols(List<PerfilRol> perfilrols) {
		this.perfilrols = perfilrols;
	}

	public PerfilRol addPerfilrol(PerfilRol perfilrol) {
		getPerfilrols().add(perfilrol);
		perfilrol.setPerfil(this);

		return perfilrol;
	}

	public PerfilRol removePerfilrol(PerfilRol perfilrol) {
		getPerfilrols().remove(perfilrol);
		perfilrol.setPerfil(null);

		return perfilrol;
	}
}