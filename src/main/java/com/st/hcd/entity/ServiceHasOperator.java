package com.st.hcd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.st.hcd.security.jwt.entity.Operator;

import java.util.Date;

@Entity
@NamedQuery(name="ServiceHasOperator.findAll", query="SELECT s FROM ServiceHasOperator s")
public class ServiceHasOperator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Integer createdBy;

	private Integer operatorId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	private Integer modifiedBy;

	private String status;

	private Integer serviceId;

	//bi-directional many-to-one association to Service
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="serviceId", insertable=false, updatable=false)
	private Services service;

	//bi-directional many-to-one association to Operator
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="operatorId", insertable=false, updatable=false)
	@JsonBackReference(value="operator-servicehasoperator")
	private Operator operator;

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

	public Services getService() {
		return this.service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Operator getOperator() {
		return this.operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}