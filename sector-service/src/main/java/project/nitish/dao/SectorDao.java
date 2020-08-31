package project.nitish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.nitish.model.Sector;

@Repository
public interface SectorDao extends JpaRepository<Sector, Integer> {
	
	Sector findBySectorId(Integer id);

}
