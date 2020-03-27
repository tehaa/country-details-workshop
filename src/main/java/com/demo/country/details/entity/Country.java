package com.demo.country.details.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "country")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

	@Id
	@Column(name = "code")
	private Character code;

	@Column(name = "name")
	private String name;

	@Column(name = "continent")
	private String continent;

	@Column(name = "region")
	private String region;

	@Column(name = "surface_area")
	private Float surfaceArea;

	@Column(name = "indep_year")
	private Short indepYear;

	@Column(name = "population")
	private Integer population;

	@Column(name = "life_expectancy")
	private Float lifeExpectancy;

	@Column(name = "gnp")
	private BigDecimal gnp;

	@Column(name = "gnp_old")
	private BigDecimal gnpOld;

	@Column(name = "local_name")
	private String localName;

	@Column(name = "government_form")
	private String governmentForm;

	@Column(name = "head_of_state")
	private String headOfState;

	@Column(name = "capital")
	private Integer capital;

	@Column(name = "code2")
	private Character code2;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<City> cities;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<CountryLanguage> languages ;

	public Character getCode() {
		return code;
	}

	public void setCode(Character code) {
		this.code = code;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Short getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
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

	public BigDecimal getGnp() {
		return gnp;
	}

	public void setGnp(BigDecimal gnp) {
		this.gnp = gnp;
	}

	public BigDecimal getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(BigDecimal gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public Character getCode2() {
		return code2;
	}

	public void setCode2(Character code2) {
		this.code2 = code2;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	

	public List<CountryLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<CountryLanguage> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region
				+ ", surfaceArea=" + surfaceArea + ", indepYear=" + indepYear + ", population=" + population
				+ ", lifeExpectancy=" + lifeExpectancy + ", gnp=" + gnp + ", gnpOld=" + gnpOld + ", localName="
				+ localName + ", governmentForm=" + governmentForm + ", headOfState=" + headOfState + ", capital="
				+ capital + ", code2=" + code2 + "]";
	}

}
