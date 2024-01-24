package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.model.CareerOppEntity;
import com.hrms.service.CareerOppService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CareerOppController {

	@Autowired
	CareerOppService service;

	@RequestMapping("/")
	public String getAllCareerOpp(Model model) {
//		System.out.println("getAllCareerOpp");

		List<CareerOppEntity> list = service.getAllCareerOpp();
		int count = list.size();
		model.addAttribute("career", list);
		model.addAttribute("careercount", count);

		return "index01";
	}

	@RequestMapping("/delete/{id}")
	public String deleteJobByJobCode(Model model, @PathVariable("id") Integer id) {

		System.out.println("deleteJobByJobCode");

		service.deleteJobById(id);
		return "redirect:/";

	}

	@RequestMapping("/createJobDetail")
	public String createOrUpdateJobDetail(CareerOppEntity jobdetail) {
		System.out.println("createJobDetail ");

		service.createOrUpdateJobDetail(jobdetail);

		return "redirect:/";
	}

	/*
	 * @PostMapping("/createJobDetail") public String addEmployee(@RequestBody
	 * CareerOppEntity jobdetail) { service.createOrUpdateJobDetail(jobdetail);
	 * return "redirect:/"; }
	 */

	/*
	 * @PutMapping("/employee") public void updateEmployee(@RequestBody Employee
	 * employee) { service.saveOrUpdate(employee); }
	 */
}
