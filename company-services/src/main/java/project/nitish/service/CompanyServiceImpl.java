package project.nitish.service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.Optional;
import java.lang.reflect.Type;
import org.springframework.stereotype.Service;

import project.nitish.dao.CompanyDao;
import project.nitish.dto.CompanyDto;
import project.nitish.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private CompanyDao companyDao;
	private ModelMapper modelMapper; 
	
	public CompanyServiceImpl(CompanyDao companyDao, ModelMapper modelMapper) {
		this.companyDao = companyDao;
		this.modelMapper = modelMapper;
		
	}

	@Override
	public Iterable<CompanyDto> getAllCompanies() {
		    
		    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	        Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
	        List<CompanyDto> postDtoList = modelMapper.map(companyDao.findAll(),listType);
	        return postDtoList;
	}

//	@Override
//	public Optional<CompanyDto> getCompanyByName(String name) {
//		return companyDao.findCompanyByCompanyName(name);
//	}

	@Override
	public CompanyDto addCompany(CompanyDto companyDto) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Company company =companyDao.save(modelMapper.map(companyDto,Company.class));
        return modelMapper.map(company,CompanyDto.class);
		
	}

	@Override
	public CompanyDto updateCompany(CompanyDto companyDto, Integer companyId) {
		Company company = companyDao.findByCompanyId(companyId).get();
		company.setCompanyName(companyDto.getCompanyName());
		company.setCeo(companyDto.getCeo());
		company.setBoardOfDirectors(companyDto.getBoardOfDirectors());
		company.setDescription(companyDto.getDescription());
		company.setSector(companyDto.getSector());
		company.setStockExchanges(companyDto.getStockExchanges());
		company.setCodeInStockExchange(companyDto.getCodeInStockExchange());
		companyDao.save(company);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(company,CompanyDto.class);
		
	}

	@Override
	public void deleteCompany(Integer companyId) {
		Company company = companyDao.findByCompanyId(companyId).get();
		companyDao.delete(company);
		
	}

	@Override
	public List<CompanyDto> searchByPattern(String pattern)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
        List<CompanyDto> postDtoList = modelMapper.map(companyDao.findByCompanyNameContaining(pattern),listType);
        return postDtoList;
		
	}

	@Override
	public List<CompanyDto> searchSectorCompanies(Integer sector) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
        List<CompanyDto> postDtoList = modelMapper.map(companyDao.findBySector(sector),listType);
        return postDtoList;
		
		
	}
	
	@Override
	public List<CompanyDto> searchStockCompanies(String stockExchange){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDto>>(){}.getType();
        List<CompanyDto> postDtoList = modelMapper.map(companyDao.findByStockExchanges(stockExchange),listType);
        return postDtoList;
		
		
	}
}
