package com.st.hcd.security.jwt.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	private int id;

	private String name;

	@JsonIgnore
	private String status;

	//bi-directional many-to-one association to Operatorrole
	//@OneToMany(mappedBy="rol")
	//private List<OperatorRole> operatorroles;

	//bi-directional many-to-one association to Perfilrol
	//@OneToMany(mappedBy="rol")
	//private List<PerfilRol> perfilrols;

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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public List<OperatorRole> getOperatorroles() {
//		return this.operatorroles;
//	}
//
//	public void setOperatorroles(List<OperatorRole> operatorroles) {
//		this.operatorroles = operatorroles;
//	}
//
//	public List<PerfilRol> getPerfilrols() {
//		return this.perfilrols;
//	}
//
//	public void setPerfilrols(List<PerfilRol> perfilrols) {
//		this.perfilrols = perfilrols;
//	}

//	public PerfilRol addPerfilrol(PerfilRol perfilrol) {
//		getPerfilrols().add(perfilrol);
//		perfilrol.setRol(this);
//
//		return perfilrol;
//	}
//
//	public PerfilRol removePerfilrol(PerfilRol perfilrol) {
//		getPerfilrols().remove(perfilrol);
//		perfilrol.setRol(null);
//
//		return perfilrol;
//	}

}