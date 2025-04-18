package com.firstjobapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstjobapp.model.JobModel;
import com.firstjobapp.service.JobService;

@RestController
@RequestMapping("/job")
public class jobController {
	private JobService jobService;
//	private CompanyService companyservice;

	public jobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/getjobs")
	public ResponseEntity<List<JobModel>> finaAll() {
		return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/addjob")
	public ResponseEntity<String> createjob(@RequestBody JobModel job) {
		jobService.createjob(job);

		return new ResponseEntity<>("Job added Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getjob/{Id}")
	public ResponseEntity<JobModel> getjobbyid(@PathVariable Long Id) {
//		HttpStatus
		JobModel job = jobService.getJobById(Id);
		if (job != null) {
//			   return ResponseEntity.ok(job);
			return new ResponseEntity<>(job, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	@DeleteMapping("/deletejob/{Id}")
	public ResponseEntity<String> deletejob(@PathVariable Long Id){
		boolean deletejob = jobService.deleteJobById(Id);
		if  (deletejob) {
			return new ResponseEntity<>("Job deleted Successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Job not found or invild id",HttpStatus.NOT_FOUND); 
		}
		
	}
	@PostMapping("/updatejob/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long Id,@RequestBody JobModel updatedJob ){
		boolean updatejob = jobService.updateJobById(Id,updatedJob);
		if (updatejob) {
			return new ResponseEntity<>("Job Updated Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Something went wornge",HttpStatus.NOT_FOUND);

		}
	
	}

}
