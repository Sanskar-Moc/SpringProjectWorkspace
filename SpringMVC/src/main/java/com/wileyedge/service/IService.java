package com.wileyedge.service;

import java.util.List;

import com.wileyedge.Employee;


public interface IService {
	public void saveEmployees(List<Employee>empList);
	public void modifyEmployees(List<Employee>empList);
}
