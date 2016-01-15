package com.hiero.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.hiero.service.CarManager;

@Controller
public class CarListController{
	
	@RequestMapping("/cars")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
 
		CarManager carManager = new CarManager();
 
		ModelAndView modelAndView = new ModelAndView("carList");
		modelAndView.addObject("carList", carManager.getCarList());
 
		return modelAndView;
	}
}