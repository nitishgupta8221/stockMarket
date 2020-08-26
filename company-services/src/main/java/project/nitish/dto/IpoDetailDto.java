package project.nitish.dto;

public class IpoDetailDto {
	private Integer ipoId;
	private String companyName;
	private String stockExchange;
	private Float pricePerShare;
	private Integer noOfShares;
	private String openingDate;
	private String openingTime;

	public IpoDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IpoDetailDto(Integer ipoId, String companyName, String stockExchange, Float pricePerShare,
			Integer noOfShares, String openingDate, String openingTime) {
		super();
		this.ipoId = ipoId;
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.noOfShares = noOfShares;
		this.openingDate = openingDate;
		this.openingTime = openingTime;
	}

	public Integer getIpoId() {
		return ipoId;
	}

	public void setIpoId(Integer ipoId) {
		this.ipoId = ipoId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(Float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Integer getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(Integer noOfShares) {
		this.noOfShares = noOfShares;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

}
