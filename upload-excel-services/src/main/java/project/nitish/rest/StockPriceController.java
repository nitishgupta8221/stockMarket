package project.nitish.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.nitish.model.StockPrice;
import project.nitish.service.StockPriceService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RestController
public class StockPriceController {

	private StockPriceService stockPriceService;

	public StockPriceController(StockPriceService stockPriceService) {
		this.stockPriceService = stockPriceService;
	}

	@PostMapping("/importStockPriceDetails")
	public ResponseEntity<List<StockPrice>> addDataFromCsvToDb(@RequestParam("file") MultipartFile stockDataFile)
			throws IOException {
		List<StockPrice> stockPrices = new ArrayList<>();
		XSSFWorkbook book = new XSSFWorkbook(stockDataFile.getInputStream());
		XSSFSheet sheet = book.getSheetAt(0);
		for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
			StockPrice curr = new StockPrice();
			XSSFRow row = sheet.getRow(i);
			if (row == null)
				break;
			curr.setCompanyId((int) row.getCell(0).getNumericCellValue());
			curr.setStockExchange(row.getCell(1).getStringCellValue());
			curr.setPricePerShare((float) row.getCell(2).getNumericCellValue());
			curr.setDate(row.getCell(3).getDateCellValue());
			curr.setTime(row.getCell(4).getStringCellValue());
			
			stockPrices.add(curr);
		}

		return new ResponseEntity<List<StockPrice>>(stockPriceService.addStockPriceData(stockPrices), HttpStatus.OK);

	}

}
