package com.wileyedge.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "dept2")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "dname")
	private String deptName;
//	The mappedBy attribute of @OneToMany annotation behaves the same as inverse = true
//	So "employees" is the relationship_owner and not the Department
//	@OneToMany(targetEntity = Employee.class,mappedBy = "dept")
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	private List<Employee>employees;

	public Department () {}
	
	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
