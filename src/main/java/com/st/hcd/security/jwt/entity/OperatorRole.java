package com.st.hcd.security.jwt.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;

@Entity
@NamedQuery(name="OperatorRole.findAll", query="SELECT o FROM OperatorRole o")
public class OperatorRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	@JsonIgnore
	private int id;

	@JsonIgnore
	private int createdBy;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	@JsonIgnore
	private Integer modifiedBy;

	@JsonIgnore
	private String status;

	//bi-directional many-to-one association to Operator
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="operatorId", insertable=false, updatable=false)
//	private Operator operator;
	
	private Integer operatorId;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rolId", insertable=false, updatable=false)
	@JsonBackReference(value="operator-operatorroles")
	private Rol rol;
	
	private Integer rolId;

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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public Operator getOperator() {
//		return this.operator;
//	}
//
//	public void setOperator(Operator operator) {
//		this.operator = operator;
//	}

	public Rol getRol() {
		return this.rol;
	}

//	public void setRol(Rol rol) {
//		this.rol = rol;
//	}
}