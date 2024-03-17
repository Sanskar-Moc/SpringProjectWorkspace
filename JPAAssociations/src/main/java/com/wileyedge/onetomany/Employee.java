package com.wileyedge.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "empl2")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "FirstName")
	private String fname;
	@Column(name = "LastName")
	private String lname;
	
//	@ManyToOne
//	private Department dept;
	
	public Employee() {}
	
	
	public Employee(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
//
//	public Department getDept() {
//		return dept;
//	}
//
//	public void setDept(Department dept) {
//		this.dept = dept;
//	}
	
	
}
