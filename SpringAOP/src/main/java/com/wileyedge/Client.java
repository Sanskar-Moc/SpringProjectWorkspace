package com.wileyedge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wileyedge.dao.IDao;
import com.wileyedge.model.Employee;
import com.wileyedge.service.EmployeeService;
import com.wileyedge.service.IService;

public class Client {

	public static void main(String[] args) {
		
		List<Employee>employees=new ArrayList<Employee>();
		employees.add(new Employee(126,"Jesus","Christ"));
		employees.add(new Employee(127,"Josephssss","Christ"));
		employees.add(new Employee(128,"Jason","John"));
		
		ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");
		
		IDao dao=context.getBean("dao",IDao.class);
		
		IService es=context.getBean("service",IService.class);
		es.saveEmployees(employees);
//		es.modifyEmployees(employees);
		
//		System.out.println(dao.getAllEmployees());
//		System.out.println("===============================");
//		System.out.println(dao.getEmployeeById(10));
//		System.out.println("===============================");
//		System.out.println(dao.getEmployeeNameById(10));
//		System.out.println("===============================");
//		System.out.println(dao.getEmployeeCount());
		
	}

}
