package com.firstjobapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.firstjobapp.model.JobModel;
import com.firstjobapp.repository.JobRepository;
import com.firstjobapp.service.JobService;

@Service
public class JobServiceImpl implements JobService {
//	List<JobModel> jobs = new ArrayList<>();
	JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

//	private Long nextId = 1L;

	@Override
	public List<JobModel> findAll() {

		return jobRepository.findAll();
	}

	@Override
	public void createjob(JobModel job) {
//		job.setId(nextId++);
//		jobs.add(job);
		jobRepository.save(job);
	}

	@Override
	public JobModel getJobById(Long id) {
//		for (JobModel job : jobs) {
//			if (job.getId().equals(id)) {
//				return job;
//			}
//		}
//		return null
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		// using java 8 features
//		return jobs.removeIf(job -> job.getId().equals(id));
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
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJobById(Long Id, JobModel updatedJob) {
		Optional<JobModel> optionjob = jobRepository.findById(Id);
		
			if (optionjob.isPresent()){
				JobModel job = optionjob.get();
				job.setTitle(updatedJob.getTitle());
				job.setDescription(updatedJob.getDescription());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setMinSalary(updatedJob.getMinSalary());
				job.setLocation(updatedJob.getLocation());
				jobRepository.save(job);
				return true;
			}
		

		return false;
	}

}
