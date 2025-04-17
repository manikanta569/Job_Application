package com.firstjobapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.firstjobapp.model.JobModel;
import com.firstjobapp.service.JobService;
@Service
public class JobServiceImpl implements JobService {
	List<JobModel> jobs = new ArrayList<>();

	@Override
	public List<JobModel> findAll() {

		return jobs;
	}

	@Override
	public void createjob(JobModel job) {
		jobs.add(job);
	}

}
