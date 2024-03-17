package com.wileyedge;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "e3")// replacement of bean tag of employee
public class Employee implements BeanNameAware,ApplicationContextAware

//, InitializingBean 
{
	@Value("30")
	private int id;
	@Value("Joseph")
	private String fname;
	@Value("Kumar")
	private String lname;
	@Autowired
//	@Qualifier(value="a5")
	private Address addr;
	private ApplicationContext context;
	
	public Employee() {
		super();
		System.out.println("Inside default constructor of employee");
		
	}
	public Employee(Address addr){
		System.out.println("inside parameterized constructor of employee");
//		setAddr(addr);
		this.addr=addr;
	}
	
	public Address getAddr() {
		return addr;
	}
	
	public void setAddr(Address addr) {
		System.out.println("inside setAddr()");
		this.addr = addr;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("inside setId() "+id);
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		System.out.println("inside setFname() "+fname);
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		System.out.println("inside setLname() "+lname);
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", addr=" + addr.toString() + "]";
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.print("inside setBeanName() amethod of employee ");
		System.out.println(beanName);
	}
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("inside set application context of employee "+context);
		this.context=context;
	}
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("insde afterPropertiesSet() of employee ");
//		
//	}
	public void myInit() {
		System.out.println("inside custom myInit() of employee");
		this.fname="Jason";
//		this.addr=context.getBean("a2",Address.class);
	}
	
	public void myDestroy() {
		System.out.println("inside myDestroy()");
		this.addr=null;
	}
	
	
	
}
