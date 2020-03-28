package com.demo.country.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.country.details.entity.CountryLanguage;
import com.demo.country.details.repo.CountryLanguageRepo;

@Service
public class CountryLanguageService {

	@Autowired
	private CountryLanguageRepo countryLanguageRepo;

	/**
	 * 
	 * @param paging
	 * @return
	 */
	public ResponseEntity<Page<CountryLanguage>> getLanguages(Pageable paging) {
		Page<CountryLanguage> languagePage = countryLanguageRepo.findAll(paging);
		return ResponseEntity.status(HttpStatus.OK).body(languagePage);
	}

}
