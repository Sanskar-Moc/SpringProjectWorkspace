package com.wileyedge.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class ManyToMany {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx= em.getTransaction();
		Employee e1=new Employee("Jonathon","Richards");
		Employee e2=new Employee("Chris","McKarthy");
		Employee e3=new Employee("Allen","Milburn");
		
		TechSkill s1=new TechSkill("Java");
		TechSkill s2=new TechSkill("Python");
		
		List<Employee>javaemps=new ArrayList<>() {
			{
				add(e1);
				add(e2);
			}
		};
		List<Employee>pythonemps=new ArrayList<>() {
			{
				add(e2);
				add(e3);
			}
		};
		
		s1.setEmployees(javaemps);
		s2.setEmployees(pythonemps);
		
		tx.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(s1);
		em.persist(s2);
		tx.commit();
	}

}
