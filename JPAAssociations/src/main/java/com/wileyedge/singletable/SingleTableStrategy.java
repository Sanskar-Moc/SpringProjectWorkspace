package com.wileyedge.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class SingleTableStrategy {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx= em.getTransaction();
		
		Employee e1=new PermanentEmployee("Julia", "Cooper", 100);
		Employee e2=new PermanentEmployee("Marissa", "Cooper", 101);
		Employee e3=new ContractEmployee("Ryan", "Atwood", "Wiley");
		Employee e4=new ContractEmployee("Seth", "Cohen", "Wiley");
		
		tx.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		tx.commit();
	}

}
