package com.st.hcd.security.jwt.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


@Entity
@NamedQuery(name="PerfilOperator.findAll", query="SELECT p FROM PerfilOperator p")
public class PerfilOperator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	private int id;

	@JsonIgnore
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dateModified;

	@JsonIgnore
	private Integer modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date validFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date validUntil;

	private Integer operatorId;

	private Integer perfilId;

	//bi-directional many-to-one association to Operator
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="operatorId", insertable=false, updatable=false)
	@JsonBackReference(value="operator-perfiloperator")
	private Operator operator;

	//bi-directional many-to-one association to Perfil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="perfilId", insertable=false, updatable=false)
	@JsonBackReference(value="operator-perfil")
	private Perfil perfil;

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

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

//	public Operator getOperator() {
//		return this.operator;
//	}
//
//	public void setOperator(Operator operator) {
//		this.operator = operator;
//	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}