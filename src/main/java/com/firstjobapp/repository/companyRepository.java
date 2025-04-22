package com.firstjobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstjobapp.model.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

}
