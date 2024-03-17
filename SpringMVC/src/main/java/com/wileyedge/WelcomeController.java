package com.wileyedge;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WelcomeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside controller");
		System.out.println("Going to invoke buisness methds");
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("msg", "welcome to spring mvc");
		return mav;
	}

}
