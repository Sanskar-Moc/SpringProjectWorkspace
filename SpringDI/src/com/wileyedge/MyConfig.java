package com.wileyedge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // its like replacement of entire xml file
@ComponentScan(basePackages = "com.wileyedge")
public class MyConfig {
	@Bean(name = "a4")
	public Address getAddr1() {
		Address a=new Address("Varanasi","India",221001);
		return a;
	}
	@Bean(name = "a5")
	@Primary
	public Address getAddr2() {
		Address a=new Address("Kanpur","India",208024);
		return a;
	}

}
