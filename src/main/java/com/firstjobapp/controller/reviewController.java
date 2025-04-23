package com.firstjobapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstjobapp.model.ReviewModel;
import com.firstjobapp.service.ReviewService;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping
	public ResponseEntity<List<ReviewModel>> getAllReview(@PathVariable Long companyId) {
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

	}

}

/*
 * GET / companies/{companyId}/reviews POST /companies/ {companyId}/reviews GET
 * /companies/{companyId}/reviews/{reviewId} PUT
 * /companies/{companyId}/reviews/{reviewId} DELETE
 * /companies/{companyId}/reviews/{reviewId}
 */