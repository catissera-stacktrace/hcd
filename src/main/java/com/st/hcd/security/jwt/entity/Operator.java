package com.st.hcd.security.jwt.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.st.hcd.entity.Person;
import com.st.hcd.entity.Schedule;
import com.st.hcd.entity.ServiceHasOperator;
import com.st.hcd.security.jwt.entity.OperatorRole;
import com.st.hcd.security.jwt.entity.Rol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="Operator.findAll", query="SELECT o FROM Operator o")
public class Operator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dateModified;

	@JsonIgnore
	private Integer modifiedBy;
	@JsonIgnore
	private String password;

	private int serviceId;

	@JsonIgnore
	private String status;

	private String userName;

	@JsonIgnore
	private String email;
	
	//bi-directional many-to-one association to Person
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personid", insertable=false, updatable=false)
	@JsonBackReference(value="person-operator")
	private Person person;

	public Person getPerson() {
		return this.person;
	}

	//bi-directional many-to-one association to Operatorrole
	@JsonIgnore
	@OneToMany(mappedBy="operatorId")
	@JsonManagedReference(value="operator-operatorroles")
	private List<OperatorRole> operatorroles;

	//bi-directional many-to-one association to Perfiloperator
	@JsonIgnore
	@OneToMany(mappedBy="operatorId")
	@JsonManagedReference(value="operator-perfiloperators")
	private List<PerfilOperator> perfiloperators;

	//bi-directional many-to-one association to Schedule
	@JsonIgnore	
	@OneToMany(mappedBy="createdBy")
	@JsonManagedReference(value="operator-schedule")
	private List<Schedule> schedules;

	//bi-directional many-to-one association to Servicehasoperator
	@JsonIgnore
	@OneToMany(mappedBy="operatorId")
	@JsonManagedReference(value="operator-servicehasoperators")
	private List<ServiceHasOperator> servicehasoperators;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<OperatorRole> getOperatorroles() {
		return this.operatorroles;
	}

	public void setOperatorroles(List<OperatorRole> operatorroles) {
		this.operatorroles = operatorroles;
	}

	public List<PerfilOperator> getPerfiloperators() {
		return this.perfiloperators;
	}

	public void setPerfiloperators(List<PerfilOperator> perfiloperators) {
		this.perfiloperators = perfiloperators;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public List<ServiceHasOperator> getServicehasoperators() {
		return this.servicehasoperators;
	}

	public void setServicehasoperators(List<ServiceHasOperator> servicehasoperators) {
		this.servicehasoperators = servicehasoperators;
	}

	public ServiceHasOperator addServicehasoperator(ServiceHasOperator servicehasoperator) {
		getServicehasoperators().add(servicehasoperator);
		servicehasoperator.setOperator(this);

		return servicehasoperator;
	}

	public ServiceHasOperator removeServicehasoperator(ServiceHasOperator servicehasoperator) {
		getServicehasoperators().remove(servicehasoperator);
		servicehasoperator.setOperator(null);

		return servicehasoperator;
	}

	public String getEmail() {
		return this.getPerson().getEmail();
	}

	public List<Rol> getRoles() {
		List<Rol> roles = new ArrayList<Rol>();
		List<Perfil> perfiles = new ArrayList<Perfil>();
		List<PerfilRol> perfilRoles = new ArrayList<PerfilRol>();

		/* Buscamos por Roles del Operador */
		for (OperatorRole operatorRole :  operatorroles) {
			roles.add(operatorRole.getRol());
		}

		/* Buscamos por Roles del Perfil del Operador */		
		for (PerfilOperator perfilOperator :  perfiloperators) {
			perfiles.add(perfilOperator.getPerfil());
		}

		for (Perfil perfil :  perfiles) {
			perfilRoles = perfil.getPerfilrols() ;
		}

		for (PerfilRol perfilRol :  perfilRoles) {
			roles.add(perfilRol.getRol());
		}
		
		return roles;
	}

	@JsonIgnore
	@Column(name="person_id")
	private int personId;	

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

}