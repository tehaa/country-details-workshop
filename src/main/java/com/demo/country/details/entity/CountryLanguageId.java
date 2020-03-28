package com.demo.country.details.entity;

import java.io.Serializable;

public class CountryLanguageId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Country country;

	private String language;

	
	public CountryLanguageId() {
		super();
	}

	public CountryLanguageId(Country country, String language) {
		super();
		this.country = country;
		this.language = language;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	

}
