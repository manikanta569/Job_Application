package com.firstjobapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

	public jobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping("/getjobs")
	public List<JobModel> finaAll() {
		return jobService.findAll();
	}

	@PostMapping("/addjob")
	public String createjob(@RequestBody JobModel job) {
		jobService.createjob(job);

		return "Job added Successfully";
	}

}
