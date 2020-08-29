package com.microservice.companydetails.dto;

public class CompanyDto {

	private int id;
	
	private String companyName;
	
	private int turnOver;
	
	private int sectorid;
	
	private String description;

	public CompanyDto() {
	}

	public CompanyDto(int id, String companyName, int turnOver, int sectorid, String description) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.turnOver = turnOver;
		this.sectorid = sectorid;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}

	public int getSectorid() {
		return sectorid;
	}

	public void setSectorid(int sectorid) {
		this.sectorid = sectorid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
