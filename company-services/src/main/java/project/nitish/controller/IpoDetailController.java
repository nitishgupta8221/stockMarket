package project.nitish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Iterable<IpoDetail>> getIpoDetails(){
		
		return new ResponseEntity<Iterable<IpoDetail>>(ipoDetailService.getIpoDetais(), HttpStatus.OK); 
	}
	
	@PostMapping("/ipoDetails/{companyName}")
	public ResponseEntity<IpoDetail> addIpoDetail(@RequestBody IpoDetail ipoDetail) {
		return new ResponseEntity<IpoDetail>(ipoDetailService.addIpoDetail(ipoDetail), HttpStatus.CREATED);
		
	}

}
