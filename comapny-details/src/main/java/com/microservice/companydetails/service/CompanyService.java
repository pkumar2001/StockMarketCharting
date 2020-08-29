package com.microservice.companydetails.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.companydetails.dto.CompanyDto;
import com.microservice.companydetails.dto.IpoDto;
import com.microservice.companydetails.helper.Helper;
import com.microservice.companydetails.model.Company;
import com.microservice.companydetails.model.IpoDetails;
import com.microservice.companydetails.repository.CompanyRepo;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public CompanyDto addCompany(Company company) {
		Company obj = companyRepo.save(company);
		return modelMapper.map(obj, CompanyDto.class);
	}
	
	public CompanyDto findCompanyByName(String companyName) {
		Company obj = companyRepo.findByCompanyName(companyName);
		if(obj==null)
		{
			return null;
		}
		return modelMapper.map(obj, CompanyDto.class);
	}
	
	public CompanyDto findCompanyById(int companyId) {
		Company obj = companyRepo.findById(companyId).get();
		return modelMapper.map(obj, CompanyDto.class);
	}
	
	public void deleteCompanyById(int companyId) {
		companyRepo.deleteById(companyId);
	}
	
	public List<CompanyDto> findAllCompany(){
		Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
		return modelMapper.map(companyRepo.findAll(), listType);
	}
	
	public List<IpoDto> findIpoDetailsByCompanyId(int companyId){
		Company company = companyRepo.findById(companyId).get();
		List<IpoDetails> ipoDetailsList = company.getIpoList();
		for(IpoDetails ipo : ipoDetailsList) {
			System.out.println(ipo);
		}
		return Helper.IpoDetailsToDto(ipoDetailsList, companyId);

	}
	
	public List<CompanyDto> findCompanyByPattern(String pattern){
		Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
		return modelMapper.map(companyRepo.findByCompanyNameStartsWith(pattern), listType);
	}
}
