package com.telusinternational.global.WuaUnit;

public class Params {
	private String country;
	private String gaUnitName;
	private String gaSubunitName;	

	public Params(String country, String gaUnitName, String gaSubunitName) {
		super();
		this.country = country;
		this.gaUnitName = gaUnitName;
		this.gaSubunitName = gaSubunitName;
	}

	public Params() {}
	
	public Params(String country, String gaUnitName) {
		super();
		this.country = country;
		this.gaUnitName = gaUnitName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGaUnitName() {
		return gaUnitName;
	}

	public void setGaUnitName(String gaUnitName) {
		this.gaUnitName = gaUnitName;
	}
	
	public String getGaSubunitName() {
		return gaSubunitName;
	}

	public void setGaSubunitName(String gaSubunitName) {
		this.gaSubunitName = gaSubunitName;
	}
}
