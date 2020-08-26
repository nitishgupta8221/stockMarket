package project.nitish.service;

import org.springframework.stereotype.Service;

import project.nitish.dao.IpoDetailDao;
import project.nitish.model.IpoDetail;

@Service
public class IpoDetailServiceImpl implements IpoDetailService {
	
	private IpoDetailDao ipoDetailDao;
	

	public IpoDetailServiceImpl(IpoDetailDao ipoDetailDao) {
		this.ipoDetailDao = ipoDetailDao;
	}

	@Override
	public Iterable<IpoDetail> getIpoDetais() {
		return ipoDetailDao.findAll();
	}

	@Override
	public IpoDetail addIpoDetail(IpoDetail ipoDetail) {
		return ipoDetailDao.save(ipoDetail);
		
	}

	

}
