package com.firstjobapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstjobapp.model.JobModel;

@RestController
@RequestMapping("/job")
public class jobController {
	List<JobModel> jobs = new ArrayList<>();

	@GetMapping("/getjobs")
	public List<JobModel> finaAll() {
		return jobs;
	}
	
	@PostMapping("/addjob")
	public String createjob(@RequestBody JobModel job) {
		jobs.add(job);
		
		return "Job added Successfully";		
	}

}
