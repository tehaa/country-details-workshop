package com.demo.country.details.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "country_language")
@IdClass(CountryLanguageId.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryLanguage {

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_code")
	@JsonBackReference
	private Country country;

	@Id
	@Column(name = "language")
	private String language;

	@Column(name = "is_official")
	private Boolean isOfficial;

	@Column(name = "percentage")
	private Float percentage;

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

	public Boolean getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(Boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

}
