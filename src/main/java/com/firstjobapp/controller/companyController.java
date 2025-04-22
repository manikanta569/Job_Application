package com.firstjobapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstjobapp.model.CompanyModel;
import com.firstjobapp.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	private CompanyService companyService; // creating object of company service because controller will use this
											// service object work with company

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
@GetMapping
	public List<CompanyModel> getAllCom() {
		return companyService.getAllcomp();
	}

}
