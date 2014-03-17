package com.sharePrices.dao;

public class CompanyShare implements Comparable<CompanyShare>{

	private String companyName;
	private int shareValue;
	private String year;
	private String month;
	
	public CompanyShare(String companyName, int shareValue, String year, String month) {
		this.companyName = companyName;
		this.shareValue = shareValue;
		this.month = month;
		this.year = year;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getShareValue() {
		return shareValue;
	}
	public void setShareValue(int shareValue) {
		this.shareValue = shareValue;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	@Override
	public int compareTo(CompanyShare share) {
		return Integer.valueOf(share.shareValue).compareTo(this.shareValue);
	}
}
