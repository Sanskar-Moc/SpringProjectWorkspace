package com.wileyedge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
//		ApplicationContext context= new ClassPathXmlApplicationContext("emp.xml");

		
		ApplicationContext context= new AnnotationConfigApplicationContext(MyConfig.class);
//		Employee emp1=context.getBean("e1",Employee.class); 
		Employee emp2=context.getBean("e3",Employee.class); 
//		if(emp1==emp2) {
//			System.out.println("they are pointing to same object");
//		}
//		else {
//			System.out.println("they are pointing to different object");
//			
//		}
//		System.out.println(emp1);
		System.out.println(emp2);
		
//		Address a1=context.getBean("a1",Address.class);
//		System.out.println(a1);
		ConfigurableApplicationContext configCtx=(ConfigurableApplicationContext)context;
		configCtx.close();
		
	}

}
