package com.wileyedge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "a3")//replacement of bean tag of address
public class Address {
//	@Value("Nagpur")
	private String city;
//	@Value("India")
	private String country;
//	@Value("123456")
	private int zip;
	public Address() {
		System.out.println("inside address constructor");
	}
	
	public Address(String city, String country, int zip) {
		super();
		System.out.println("inside parameterized constructor of address");
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", zip=" + zip + "]";
	}
	
}
