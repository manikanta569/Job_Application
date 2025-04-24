package com.firstjobapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "companyname", length = 150)
	private String name;
	@Column(name = "comapnydescription", length = 500)
	private String description;
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<JobModel> jobs;
//	@OneToMany
//	private List<ReviewModel> review;
	
	
	
	// import com.fasterxml.jackson.annotation.JsonManagedReference;

	@JsonManagedReference
	@OneToMany(mappedBy = "companyModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ReviewModel> review;


	public CompanyModel() {

	}

	public CompanyModel(Long id, String name, String description, List<JobModel> jobs, List<ReviewModel> review) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
		this.review = review;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<JobModel> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobModel> jobs) {
		this.jobs = jobs;
	}

	public List<ReviewModel> getReview() {
		return review;
	}

	public void setReview(List<ReviewModel> review) {
		this.review = review;
	}

}
