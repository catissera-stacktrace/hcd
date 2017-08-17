package com.st.hcd.security.jwt.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
@NamedQuery(name="PerfilRol.findAll", query="SELECT p FROM PerfilRol p")
public class PerfilRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	private int id;

	@JsonIgnore
	private Integer createdBy;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	@JsonIgnore
	private Integer modifiedBy;

	@Column(name="perfilId")
	private Integer perfilId;
	
	//bi-directional many-to-one association to Perfil
	//@ManyToOne
	//@JoinColumn(name="perfilId", insertable=false, updatable=false)
	@JsonIgnore
	@Transient
	private Perfil perfil;

	@Column(name="rolId")
	private Integer rolId;
	
	@ManyToOne
	@JoinColumn(name="rolId", insertable=false, updatable=false)
	private Rol rol;
	
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

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Rol getRol() {
		return this.rol;
	}

//	public void setRol(Rol rol) {
//		this.rol = rol;
//	}

}