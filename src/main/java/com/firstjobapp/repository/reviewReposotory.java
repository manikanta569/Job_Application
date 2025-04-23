package com.firstjobapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstjobapp.model.ReviewModel;

public interface ReviewReposotory extends JpaRepository<ReviewModel, Long> 
{

	List<ReviewModel> findByCompanyModelId(Long companyId);

}
