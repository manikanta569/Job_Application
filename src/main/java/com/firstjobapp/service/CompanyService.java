package com.firstjobapp.service;

import java.util.List;

import com.firstjobapp.model.CompanyModel;

public interface CompanyService {

	List<CompanyModel> getAllcomp();

	boolean updatecompany(CompanyModel company, Long Id);

	void createcompany(CompanyModel companymodel);

	boolean deleteCompanyById(Long id);
}
