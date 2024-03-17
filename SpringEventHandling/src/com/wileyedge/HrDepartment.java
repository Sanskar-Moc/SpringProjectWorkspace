package com.wileyedge;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HrDepartment implements ApplicationContextAware {
	private ApplicationContext context;
	
	public void recruitEmployee() {
		System.out.println("New employee is recruited");
		context.publishEvent(new EmployeeRecruitEvent(this));
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("inside setApplicationContext() of HrDepartment");
		this.context=context;
	}
}
