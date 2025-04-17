package com.firstjobapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.firstjobapp.model.JobModel;
import com.firstjobapp.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	List<JobModel> jobs = new ArrayList<>();
	private Long nextId = 1L;

	@Override
	public List<JobModel> findAll() {

		return jobs;
	}

	@Override
	public void createjob(JobModel job) {
		job.setId(nextId++);
		jobs.add(job);
	}

	@Override
	public JobModel getJobById(Long id) {
		for (JobModel job : jobs) {
			if (job.getId().equals(id)) {
				return job;
			}
		}
		return null;
	}

	@Override
	public boolean deleteJobById(Long id) {
		// using java 8 features
		return jobs.removeIf(job -> job.getId().equals(id));
		// second and simple way
//		Iterator<JobModel> iterator = jobs.iterator();
//		while (iterator.hasNext()) {
//			JobModel jobModel = iterator.next();
//			if (jobModel.getId().equals(id)) {
//				iterator.remove();
//				return true;
//			}
//
//		}
//		return false;
	}

	@Override
	public boolean updateJobById(Long id, JobModel updatedJob) {
		
		return false;
	}

}
