package project.nitish.service;


import project.nitish.model.IpoDetail;

public interface IpoDetailService {

	public Iterable<IpoDetail> getIpoDetais();
	
	public IpoDetail addIpoDetail(IpoDetail ipoDetail);
	
	
}
