package com.wileyedge.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.onetomany.Employee;
import com.wileyedge.utility.EntityManagerHelper;

public class OneToMany {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx= em.getTransaction();
		Employee e1=new Employee("James","McKenny");
		Employee e2=new Employee("Jonathan","McKenny");
		Employee e3=new Employee("John","McKenny");
		List<Employee>list1=new ArrayList<Employee>() {
			{
				add(e1);
				add(e2);
				add(e3);
			}
		};
		Department d1=new Department("Java Department");
		d1.setEmployees(list1);
		List<Employee>list2=new ArrayList<Employee>() {
			{
				add(new Employee("Jamey","Tennyson"));
				add(new Employee("Roxane","Tennyson"));
			}
		};
		Department d2=new Department("Python Department");
		d2.setEmployees(list2);
		tx.begin();
		em.persist(d1);
		em.persist(d2);
		tx.commit();
	}

}
