package com.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employeeId")
	private Integer employeeId;
	
	@Column(name="name",unique = true,nullable = false)
	private String name;
	@Column(name="email",unique = true,nullable = false)
	private String email;
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<AccountEntity> getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(Set<AccountEntity> accountEntity) {
		this.accountEntity = accountEntity;
	}

	@Column(name="password",unique = true,nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "employeeEntity",cascade = CascadeType.ALL)
	/* @JoinColumn(name="employeeId") */
	private Set<AccountEntity> accountEntity;
}
