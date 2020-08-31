package project.nitish.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.nitish.model.StockPrice;
import project.nitish.repo.StockPriceDao;

@Service
public class StockPriceServiceImpl implements StockPriceService {
	
	private StockPriceDao stockPriceDao;
	
	public StockPriceServiceImpl(StockPriceDao stockPriceDao) {
		this.stockPriceDao = stockPriceDao;
	}

	@Override
	public List<StockPrice> addStockPriceData(List<StockPrice> stockPrices) {
		
		for(StockPrice stockPrice:stockPrices ) {
			stockPriceDao.save(stockPrice);
		}
		
		return stockPrices;
	}

	
}
