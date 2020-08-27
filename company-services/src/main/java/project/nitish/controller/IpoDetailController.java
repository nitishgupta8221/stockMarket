package project.nitish.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.nitish.model.IpoDetail;
import project.nitish.service.IpoDetailService;

@RestController
public class IpoDetailController {
	
	private IpoDetailService ipoDetailService;
	
	public IpoDetailController(IpoDetailService ipoDetailService) {
		this.ipoDetailService = ipoDetailService;
	}




	@GetMapping("/ipoDetails/{companyName}")
	public ResponseEntity<List<IpoDetail>> getIpoDetails(@PathVariable("companyName") String companyName){
		
		return new ResponseEntity<List<IpoDetail>>(ipoDetailService.getIpoDetails(companyName),HttpStatus.OK); 
	}
	
	@PostMapping("/ipoDetails")
	public ResponseEntity<IpoDetail> addIpoDetail(@RequestBody IpoDetail ipoDetail) {
		
		return new ResponseEntity<IpoDetail>(ipoDetailService.addIpoDetail(ipoDetail), HttpStatus.CREATED);
		
	}

}
