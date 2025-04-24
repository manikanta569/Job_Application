package com.firstjobapp.controller;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.firstjobapp.model.ReviewModel;
import com.firstjobapp.service.ReviewService;

// 5:34  
@RestController
@Controller
@RequestMapping("/company/{companyId}")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping
	public ResponseEntity<List<ReviewModel>> getAllReview(@PathVariable Long companyId) {
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

	}

	@PostMapping("/reviews")
	public ResponseEntity<String> addReviews(@PathVariable Long companyId, @RequestBody ReviewModel reviewModel) {
		boolean isReviewSaved = reviewService.addreview(companyId, reviewModel);
		if (isReviewSaved)
			return new ResponseEntity<>("Review added successfully ", HttpStatus.OK);
		else {
			return new ResponseEntity<>("Review Not saved  ", HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<ReviewModel> getreview(@PathVariable Long companyId, @PathVariable Long reviewId) {
		return new ResponseEntity<>(reviewService.getreview(companyId, reviewId), HttpStatus.OK);

	}

	@PutMapping("/updatereview/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
			@RequestBody  ReviewModel reviewModel) {
		boolean isReviewupdated = reviewService.updateReview(companyId, reviewId, reviewModel);
		if(isReviewupdated) {
			return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>("Review not Updated",HttpStatus.NOT_FOUND);
		}
	}
	
// DELETE/companies/{companyId}/reviews/{reviewId}
	@DeleteMapping("/deletereview/{reviewId}")
	public ResponseEntity<String> deletereview(@PathVariable Long companyId ,@PathVariable Long reviewId){
		boolean isReviewDeleted = reviewService.deleteReview(companyId,reviewId);
		if(isReviewDeleted) {
		return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> ("Something went worng",HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}

/*
 * GET / companies/{companyId}/reviews POST /companies/ {companyId}/reviews
 * GET/companies/{companyId}/reviews/{reviewId}
 * PUT/companies/{companyId}/reviews/{reviewId}
 * DELETE/companies/{companyId}/reviews/{reviewId}
 */