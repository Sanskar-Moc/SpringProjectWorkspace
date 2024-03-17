package com.wileyedge.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class OneToOne {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		Employee e=new Employee("James","McKenny");
		Address a =new Address("Kanpur","208024");
		em.persist(a);
		e.setAddress(a);
		em.persist(e);
		tx.commit();
	}

}
