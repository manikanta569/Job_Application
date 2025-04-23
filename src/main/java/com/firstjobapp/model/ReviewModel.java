package com.firstjobapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class ReviewModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "title", length = 150)
	private String title;
	@Column(name = "reviewdescription", length = 150)
	private String description;
	@Column(name = "reating")
	private double rating;

	@JsonIgnore // the reason to mention @JsonIgnore is we will be having same linking in the
				// compamyModel too
	@ManyToOne
	private CompanyModel companyModel;

	

	public ReviewModel(Long id, String title, String description, double rating, CompanyModel companyModel) {
		super();
		Id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.companyModel = companyModel;
	}

	public ReviewModel() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public CompanyModel getCompanyModel() {
		return companyModel;
	}

	public void setCompanyModel(CompanyModel companyModel) {
		this.companyModel = companyModel;
	}
	

}
