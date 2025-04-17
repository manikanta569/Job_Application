package com.firstjobapp.service;

import java.util.List;

import com.firstjobapp.model.JobModel;

public interface JobService {
	List<JobModel> findAll();

	void createjob(JobModel job);

	JobModel getJobById(Long id);

	boolean deleteJobById(Long id);

	boolean updateJobById(Long id, JobModel updatedJob);

}
