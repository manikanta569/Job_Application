package com.firstjobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstjobapp.model.JobModel;

public interface JobRepository extends JpaRepository<JobModel, Long> {

}

/*
 * we can write like this also but JPA repo will have this and along with it
 * some other methods too public interface jobRepository extends
 * CrudRepository<JobModel, Long> {
 * 
 * }
 * 
 */
