package com.wileyedge.tableperclass;

import javax.persistence.Entity;

@Entity(name = "contra5")
public class ContractEmployee extends Employee {
	private String contractorName;


	public ContractEmployee(String fname, String lname, String contractorName) {
		super(fname, lname);
		this.contractorName=contractorName;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}


}
