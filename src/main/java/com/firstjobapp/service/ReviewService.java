package com.firstjobapp.service;

import java.util.List;

import com.firstjobapp.model.ReviewModel;

public interface ReviewService {
	List<ReviewModel> getAllReviews(Long companyId);

}
