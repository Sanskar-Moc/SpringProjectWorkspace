package com.wileyedge.jpql;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		IDao dao=new EmployeeDao();
		dao.createEmployee("Jesus", "Christ");
		dao.createEmployee("Jason", "Christ");
		List<Employee>emps=dao.getEmployees();
//		System.out.println(emps);
		emps.stream().forEach(System.out::println);
		
		dao.displayEmployeesByIdFnameUsingCriteria(2, "Jason");
	}

}
