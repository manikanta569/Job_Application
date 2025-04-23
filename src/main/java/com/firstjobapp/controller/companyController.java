package com.firstjobapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity< List<CompanyModel> >getAllCom() {
		return new ResponseEntity<>( companyService.getAllcomp(),HttpStatus.OK);

	}

	@PutMapping("/updatecompany/{Id}")

	public ResponseEntity<String> updatcompany(@PathVariable Long Id, @RequestBody CompanyModel company) {
		companyService.updatecompany(company, Id);

		return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
	}
	
	
	@PostMapping("/addcompany")
	public ResponseEntity<String> createcompany(@RequestBody CompanyModel companyModel) {
		companyService.createcompany(companyModel);

		return new ResponseEntity<>("Company added Successfully", HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deletecompany/{Id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long Id) {
	    boolean isDeleted = companyService.deleteCompanyById(Id);
	    if (isDeleted) {
	        return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Company not found or invalid ID", HttpStatus.NOT_FOUND);
	    }
	}


}
