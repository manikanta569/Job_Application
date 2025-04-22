package com.firstjobapp.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firstjobapp.model.CompanyModel;
import com.firstjobapp.repository.CompanyRepository;
import com.firstjobapp.service.CompanyService;
@Service
public class ComanpyServiceImpl implements CompanyService {

	CompanyRepository companyRepository;

	public ComanpyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public List<CompanyModel> getAllcomp() {
		
		return companyRepository.findAll();
	}


}
