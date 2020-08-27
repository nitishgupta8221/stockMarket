package project.nitish.service;


import java.util.List;

import project.nitish.model.IpoDetail;

public interface IpoDetailService {

	public List<IpoDetail> getIpoDetails(String companyName);
	
	public IpoDetail addIpoDetail(IpoDetail ipoDetail);
	
	
}
