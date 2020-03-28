package com.demo.country.details.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO {
	
	private String name;
	
	private String continent;
	
	private Integer population;
	
	@JsonProperty(value = "life_expectancy") 
	private Float lifeExpectancy;
	
	@JsonProperty(value = "country_language")
	private String countryLanguage;
	
	
	public CountryDTO(String name, String continent, Integer population, Float lifeExpectancy) {
		super();
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
	}

	public CountryDTO(String name, String continent, Integer population, Float lifeExpectancy, String countryLanguage) {
		super();
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
		this.countryLanguage = countryLanguage;
	}
	

	public CountryDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getCountryLanguage() {
		return countryLanguage;
	}

	public void setCountryLanguage(String countryLanguage) {
		this.countryLanguage = countryLanguage;
	}

	@Override
	public String toString() {
		return "CountryDTO [name=" + name + ", continent=" + continent + ", population=" + population
				+ ", lifeExpectancy=" + lifeExpectancy + ", countryLanguage=" + countryLanguage + "]";
	}
	
	
	
	

}
