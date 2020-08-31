package project.nitish.service;

import java.util.List;

import project.nitish.dto.StockDto;

public interface StockService {
	public StockDto getStockById(Integer stockId);
	public List<StockDto> getAllStocks();
	public StockDto createStock(StockDto stockDto);
	
	

}
