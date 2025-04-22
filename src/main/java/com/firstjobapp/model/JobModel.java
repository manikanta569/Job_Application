package com.firstjobapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobapplication")
public class JobModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	@Column(name = "jobtitle")
	private String Title;
	@Column(name = "jobdescription")
	private String Description;
	@Column(name = "minsalary")
	private String minSalary;
	@Column(name = "maxsalary")
	private String maxSalary;
	@Column(name = "joblocation")
	private String Location;
	@ManyToOne
	private CompanyModel company;

	public JobModel() {

	}

	public JobModel(Long id, String title, String description, String minSalary, String maxSalary, String location) {
		super();
		Id = id;
		Title = title;
		Description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		Location = location;
	}

	
	
	
	public CompanyModel getCompanyModel() {
		return company;
	}

	public void setCompanyModel(CompanyModel company) {
		this.company = company;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

}
