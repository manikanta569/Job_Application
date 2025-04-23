package com.firstjobapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.firstjobapp.model.CompanyModel;
import com.firstjobapp.repository.CompanyRepository;
import com.firstjobapp.repository.JobRepository;
import com.firstjobapp.service.CompanyService;

@Service
public class ComanpyServiceImpl implements CompanyService {

	CompanyRepository companyRepository;
	JobRepository jobRepository;

	public ComanpyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public List<CompanyModel> getAllcomp() {

		return companyRepository.findAll();
	}

	@Override
	public boolean updatecompany(CompanyModel company, Long Id) {
		Optional<CompanyModel> companyOptional = companyRepository.findById(Id);
		if (companyOptional.isPresent()) {
			CompanyModel updatecompany = companyOptional.get();
			updatecompany.setName(company.getName());
			updatecompany.setDescription(company.getDescription());
			updatecompany.setJobs(company.getJobs());
			companyRepository.save(updatecompany);
			return true;

		} else {

			return false;
		}
	}

	@Override
	public void createcompany(CompanyModel companymodel) {
		companyRepository.save(companymodel);
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public CompanyModel getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);

	}

//	@Override
//	public CompanyModel getCompanyById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public boolean getCompanyById(Long id) {
//		
//		if(companyRepository.existsById(id)) {
//			companyRepository.findById(id);
//			return true;
//		}
//		else {
//			return false;
//		}
//	}

}
