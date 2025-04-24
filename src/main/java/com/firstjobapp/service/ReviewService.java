package com.firstjobapp.service;

import java.util.List;

import com.firstjobapp.model.ReviewModel;

public interface ReviewService {
	List<ReviewModel> getAllReviews(Long companyId);

	boolean addreview(Long companyId, ReviewModel reviewModel);

	ReviewModel getreview(Long companyId, Long reviewId);
	boolean updateReview(Long companyId, Long reviewId, ReviewModel reviewModel) ;

	boolean deleteReview(Long companytId, Long reviewId);

}
