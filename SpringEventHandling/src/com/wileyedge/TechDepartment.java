package com.wileyedge;

import org.springframework.context.ApplicationListener;

public class TechDepartment implements ApplicationListener<EmployeeRecruitEvent> {

	@Override
	public void onApplicationEvent(EmployeeRecruitEvent arg0) {
		System.out.println("Tech department has started processing...");
	}

}
