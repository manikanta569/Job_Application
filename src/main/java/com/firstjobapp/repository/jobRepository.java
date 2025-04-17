package com.firstjobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstjobapp.model.JobModel;

public interface jobRepository extends JpaRepository<JobModel, Long> {

}
