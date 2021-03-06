package com.hiero.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiero.model.Car;
import com.hiero.service.CarService;

@Controller
public class CarController {
	
	static Logger log = Logger.getLogger(CarController.class.getName());
	
	@Autowired
	private CarService carService;
 
	@RequestMapping("/car/list")
	public void carList(Model model) {
		
		List<Car> carList = carService.findAll();
		model.addAttribute("carList", carList);
		log.info("Show actual cars!");
	}
	
	//@RequestMapping("/car/list")
	//public String carList(Model model){
	//	List<Car> carList = carService.findAll();
	//	model.addAttribute("carList", carList);
	//	
	//	return "carList";
	//}
	
	@RequestMapping("/car/add")
	public void carAdd() {
		log.info("Show new car creator form!");
	}
	
	@RequestMapping(value="/car/add", method=RequestMethod.POST)
	public String carAddSubmit(@ModelAttribute("car") @Valid Car car, BindingResult result) {
		if(result.hasErrors()) {
			// show the form again, with the errors
			log.info("Car creation has failed!");
			return "car/add";
		}
		// validation was successful
		carService.add(car);
		log.info("Car creation was succesful!");
		return "redirect:/car/list";
	}
}