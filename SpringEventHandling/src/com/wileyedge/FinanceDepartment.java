package com.wileyedge;

import org.springframework.context.ApplicationListener;

public class FinanceDepartment implements ApplicationListener<EmployeeRecruitEvent> {

	@Override
	public void onApplicationEvent(EmployeeRecruitEvent event) {
		System.out.println("Finance department has started processing...");
		
	}

}
