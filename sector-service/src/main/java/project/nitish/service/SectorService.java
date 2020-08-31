package project.nitish.service;

import java.util.List;
//import java.util.Optional;

import project.nitish.dto.SectorDto;
//import project.nitish.model.Sector;

public interface SectorService {
	
	public SectorDto getSectorById(Integer id);
	public List<SectorDto> getAllSectors();
	public SectorDto createSector(SectorDto sectorDto);
	
	

}
