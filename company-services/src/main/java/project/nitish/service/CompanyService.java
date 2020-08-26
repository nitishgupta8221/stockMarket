package project.nitish.service;

import java.util.List;
import java.util.Optional;

import project.nitish.dto.CompanyDto;
import project.nitish.model.Company;

public interface CompanyService {
	
	public Iterable<CompanyDto> getAllCompanies();
	//public Optional<CompanyDto> getCompanyByName(String name);
	public CompanyDto addCompany(CompanyDto companyDto);
	public void deleteCompany(Integer Id);
	public CompanyDto updateCompany(CompanyDto companyDto, Integer companyId);
	public List<CompanyDto> searchByPattern(String pattern);
	

}
