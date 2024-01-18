package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.model.CareerOppEntity;
import com.hrms.service.CareerOppService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class CareerOppController {
	
	@Autowired
	CareerOppService service;

	@RequestMapping
	public String getAllCareerOpp(Model model) 
	{	
//		System.out.println("getAllCareerOpp");
		
		List<CareerOppEntity> list = service.getAllCareerOpp();

		model.addAttribute("career", list);
		
		return "index1";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteJobByJobCode(Model model, @PathVariable("id") Integer id) {
		
		System.out.println("deleteJobByJobCode");
		
		service.deleteJobById(id);
		return "redirect:/";
		
	}
	/*
	 * @RequestMapping("/createUser") public String createNewUser(Model model) {
	 * 
	 * System.out.println("createUser");
	 * 
	 * // service.deleteJobById(id); return "test";
	 * 
	 * }
	 */
	

	
	
	
}
