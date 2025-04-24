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
	public boolean addreview(Long companyId, ReviewModel reviewModel) {
		CompanyModel company = companyService.getCompanyById(companyId);
		if (company != null) {
			reviewModel.setCompanyModel(company);
			reviewReposotory.save(reviewModel);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public ReviewModel getreview(Long companyId, Long reviewId) {
		List<ReviewModel> reviewModels = reviewReposotory.findByCompanyModelId(companyId);
		return reviewModels.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, ReviewModel reviewModel) {
		if (companyService.getCompanyById(companyId) != null) {
			reviewModel.setCompanyModel(companyService.getCompanyById(companyId));
			reviewModel.setId(reviewId);
			reviewReposotory.save(reviewModel);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if (companyService.getCompanyById(companyId) != null && reviewReposotory.existsById(reviewId)) {
			ReviewModel reviewModel = reviewReposotory.findById(reviewId).orElse(null);
			CompanyModel companyModel = reviewModel.getCompanyModel();
			companyModel.getReview().remove(reviewModel);
			reviewModel.setCompanyModel(null);
			companyService.updatecompany(companyModel, companyId);
			reviewReposotory.deleteById(reviewId);
			return true;
		} else {
			return false;

		}
	}

}
