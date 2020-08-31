package project.nitish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.nitish.model.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer> {
	
	Stock findByStockId(Integer stockId);

}
