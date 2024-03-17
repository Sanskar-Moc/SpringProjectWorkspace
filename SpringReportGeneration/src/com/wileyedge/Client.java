package com.wileyedge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("report.xml");
		ReportService rs=context.getBean("rs",ReportService.class);
		rs.generateReport();
		
		ConfigurableApplicationContext configCtx=(ConfigurableApplicationContext) context;
		configCtx.close();
	}

}
