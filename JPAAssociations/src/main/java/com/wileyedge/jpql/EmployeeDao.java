package com.wileyedge.jpql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.wileyedge.utility.EntityManagerHelper;

public class EmployeeDao implements IDao {

	@Override
	public List<Employee> getEmployees() {
		System.out.println("inside getEmployees()");
		EntityManager em=EntityManagerHelper.getEntityManager();
		List<Employee> employees=em.createQuery("from Employee").getResultList();
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithIdGrX(int x) {
		System.out.println("Inside getEmployeesWithIdGrX()");
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query q = em.createQuery("FROM Employee where id >= :id order by id");
		q.setParameter("id", x);
		List<Employee> list2 = q.getResultList();
		return list2;
	}

	@Override
	public List<String> getEmployeeNames() {
		System.out.println("Inside getEmployeeNames()");
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query q = em.createQuery("select fname FROM Employee");
		List<String> list3 = q.getResultList();
		return list3;
	}

	@Override
	public List<Employee> getXEmployees(int startindex, int number) {
		System.out.println("Inside getXEmployees()");
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query q = em.createQuery("FROM Employee");
		q.setFirstResult(startindex);
		q.setMaxResults(number);
		List<Employee> list4 = q.getResultList();
		return list4;
	}

	@Override
	public List<Employee> getEmployeesUsingNamedQuery() {
		System.out.println("inside getEmployeesUsingNamedQuery()");
		EntityManager em= EntityManagerHelper.getEntityManager();
		Query q = em.createNamedQuery("get.all");
		List<Employee> list4 = q.getResultList();
		return list4;
	}

	@Override
	public List<Employee> getEmployeesUsingNativeNamedQuery() {
		System.out.println("inside getEmployeesUsingNativeNamedQuery()");
		EntityManager em= EntityManagerHelper.getEntityManager();
		Query q = em.createNamedQuery("get.all.native");
		List<Object[]> list4 = q.getResultList();
		
		List<Employee> emplist=new ArrayList<>();
		
		for(Object[] objarr:list4) {
			int id=new Integer(objarr[0].toString());
			String fname = objarr[1].toString();
			String lname = objarr[2].toString();
			emplist.add(new Employee(id,fname,lname));
			
		}
		return emplist;
	}

	@Override
	public void displayEmployeesByIdFnameUsingCriteria(int id, String fname) {
		System.out.println("inside displayEmployeesByIdFnameUsingCriteria()");
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Employee>cq= cb.createQuery(Employee.class);
	    Root<Employee> from=cq.from(Employee.class);
	    Predicate pred1=cb.equal(from.get("id"), id);
	    Predicate pred2=cb.equal(from.get("fname"), fname);
	    cq.select(from);
	    cq.where(cb.and(pred1));
	    cq.where(cb.and(pred2));
	    TypedQuery<Employee>q= em.createQuery(cq);
		List<Employee>emps=q.getResultList();
		emps.stream().forEach(System.out::println);
	    
		tx.commit();
		
	}

	@Override
	public void createEmployee(String fname, String lname) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		Employee e=new Employee(fname,lname);
		tx.begin();
		em.persist(e);
		tx.commit();
	}

}
