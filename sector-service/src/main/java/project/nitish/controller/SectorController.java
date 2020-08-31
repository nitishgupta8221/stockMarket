package project.nitish.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.nitish.cllient.CompanyClient;
import project.nitish.cllient.CompanyDto;
import project.nitish.dto.SectorDto;
import project.nitish.service.SectorService;

@RestController
public class SectorController {
	
	private SectorService sectorService;
	private CompanyClient companyClient;

	
	
	public SectorController(SectorService sectorService, CompanyClient companyClient) {
		this.sectorService = sectorService;
		this.companyClient = companyClient;
	}

	@GetMapping("/sectors")
	public ResponseEntity<List<SectorDto>> getAllSectors() {
		return new ResponseEntity<List<SectorDto>> (sectorService.getAllSectors(),HttpStatus.OK);
	}
	
	@GetMapping("/sectors/{sectorId}")
	public ResponseEntity<SectorDto> getSectorById(@PathVariable("sectorId") Integer sectorId){
		return new ResponseEntity<SectorDto> (sectorService.getSectorById(sectorId),HttpStatus.OK);
	}
	
	@PostMapping("/sectors")
	public ResponseEntity<SectorDto> createSector(@RequestBody SectorDto sectorDto){
		return new ResponseEntity<SectorDto> (sectorService.createSector(sectorDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/sectors/{sectorId}/companies")
	public ResponseEntity<List<CompanyDto>> sectorCompanies(@PathVariable("sectorId") Integer sectorId){
		return new ResponseEntity<List<CompanyDto>> (companyClient.findSectorCompanies(sectorId),HttpStatus.OK );
	}
	

}
