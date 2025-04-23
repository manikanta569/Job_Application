package com.firstjobapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firstjobapp.model.CompanyModel;
import com.firstjobapp.model.ReviewModel;
import com.firstjobapp.repository.ReviewReposotory;
import com.firstjobapp.service.CompanyService;
import com.firstjobapp.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	private final ReviewReposotory reviewReposotory;
	private final CompanyService companyService;

	public ReviewServiceImpl(ReviewReposotory reviewReposotory, CompanyService companyService) {
		super();
		this.reviewReposotory = reviewReposotory;
		this.companyService = companyService;
	}

	@Override
	public List<ReviewModel> getAllReviews(Long companyId) {
		List<ReviewModel> reviewModels = reviewReposotory.findByCompanyModelId(companyId);
		return reviewModels;
	}

	@Override
	public void addreview(Long companyId, ReviewModel reviewModel) {
		CompanyModel company = companyService.getCompanyById(companyId);
		if (company != null) {
			reviewModel.setCompanyModel(company);
			reviewReposotory.save(reviewModel);

		}

	}

}
