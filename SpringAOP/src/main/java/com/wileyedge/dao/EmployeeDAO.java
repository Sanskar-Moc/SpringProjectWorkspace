package com.wileyedge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.model.Employee;

//@Component(value="dao")
@Repository(value="dao")
public class EmployeeDAO implements IDao {
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void saveEmployee(Employee e) {
//		System.out.println("Inside DAO layer");
		String sql = "insert into employees (id,fname,lname) values(?,?,?)";
		template.update(sql,e.getEid(),e.getFname(),e.getLname());
		
		
	}

	public void modifyEmployee(Employee e) {
		// TODO Auto-generated method stub

	}

	public List<Employee> getAllEmployees() {
		String sql="select * from employees;";
		return template.query(sql,
//				new BeanPropertyRowMapper<Employee>
		new EmployeeRowMapper());
		
	}

	public Employee getEmployeeById(int empid) {
		String sql="select * from employees where id=?;";
		return template.queryForObject(sql, new Object[]{empid},new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public String getEmployeeNameById(int empid) {
		String sql="select fname from employees where id=?;";
		return template.queryForObject(sql, String.class,empid);
	}

	public int getEmployeeCount() {
		String sql="select count(*) from employees;";
		return template.queryForObject(sql, Integer.class);
	}

}
