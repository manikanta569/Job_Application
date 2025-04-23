package com.firstjobapp.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firstjobapp.model.ReviewModel;
import com.firstjobapp.repository.ReviewReposotory;
import com.firstjobapp.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewReposotory reviewReposotory;

	public ReviewServiceImpl(ReviewReposotory reviewReposotory) {
		super();
		this.reviewReposotory = reviewReposotory;
	}

	@Override
	public List<ReviewModel> getAllReviews(Long companyId) {
		List<ReviewModel> reviewModels = reviewReposotory.findByCompanyId(companyId);
		return reviewModels;
	}

}
