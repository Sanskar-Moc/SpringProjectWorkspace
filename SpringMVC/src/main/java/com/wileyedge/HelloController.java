package com.wileyedge;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
	@RequestMapping(value = "/abc.htm",method=RequestMethod.GET)
	public String sayHello1() {
		System.out.println("Inside hello1() of contoller");
		System.out.println("Invoking service layer 1");
		return "hello";
	}
	@RequestMapping(value = "/pqr.htm",method=RequestMethod.GET)
	public String sayHello2(Model model) {
		System.out.println("Inside hello2() of contoller");
		System.out.println("Invoking service layer 2");
		
		model.addAttribute("msg","welcome to string mvc using annotation");
		
		return "hello";
	}
	@RequestMapping(value = "/xyz.htm",method=RequestMethod.GET)
	public String sayHello3(Map<String,String>map) {
		System.out.println("Inside hello3() of contoller");
		System.out.println("Invoking service layer 3");
		
		map.put("msg","wlcome to string mvc using annotation");
		
		return "hello";
	}
	@RequestMapping(value = "/tuv.htm",method = RequestMethod.GET)
	public String sayHello4(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Inside sayHello4() of contoller "+request);
		System.out.println("Invoking service layer 4");
		model.addAttribute("msg","welcome to string mvc using annotation");
		return "hello";
	}
	
}
