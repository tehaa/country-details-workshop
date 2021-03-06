package com.demo.country.details.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.country.details.dto.CountryDTO;
import com.demo.country.details.dto.MessageResponse;
import com.demo.country.details.entity.Country;
import com.demo.country.details.repo.CountryRepo;
import com.demo.country.details.util.ResponseMessages;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryRepo countryRepo;

	/**
	 * 
	 * @param paging
	 * @return
	 */
	public ResponseEntity<Page<Country>> getCountries(Pageable paging) {
		Page<Country> countryPage = countryRepo.findAll(paging);
		return ResponseEntity.status(HttpStatus.OK).body(countryPage);
	}

	/**
	 * method will return country details related to country code due to can't able
	 * to use limit in jpa query i used Pageable with constant page number 0 and
	 * page size one to return row with maximum percentage
	 * 
	 * @param countryCode
	 * @return
	 */
//	public ResponseEntity<?> getCountry(String countryCode,Pageable paging) {
//		try {
//			List<CountryDTO> countryDetailsList = countryRepo.getCountryFromCode(countryCode, paging);
//			if (countryDetailsList.size() == 0) {
//				LOGGER.error("-----> error while geeting country with code : {} country not found", countryCode);
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//						.body(new MessageResponse(ResponseMessages.INVALID_COUNTRY_CODE));
//			} else {
//				return ResponseEntity.status(HttpStatus.OK).body(countryDetailsList.get(0));
//			}
//		} catch (DataAccessResourceFailureException e) {
//			LOGGER.error("error while getting country by code {}", e);
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body(new MessageResponse(ResponseMessages.INTERNAL_ERROR));
//		}
//	}

	/**
	 * this method use native query to return country details that belongs to
	 * country code param the country language is extracted from the country boolean
	 * if offical and the most percentage .
	 * 
	 * @param countryCode
	 * @return
	 */

	public ResponseEntity<?> getCountry(String countryCode) {
		LOGGER.debug("start service get country from code : {} using native query ", countryCode);

		try {
			Country country = countryRepo.getCountryFromCode(countryCode);
			if (Objects.isNull(country)) {
				LOGGER.error("-----> error while geeting country with code : {} country not found", countryCode);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(new MessageResponse(ResponseMessages.INVALID_COUNTRY_CODE));
			} else {
				CountryDTO countryDTO = constructCountryDTOfromCountry(country);
				return ResponseEntity.status(HttpStatus.OK).body(countryDTO);

			}
		} catch (DataAccessResourceFailureException e) {
			LOGGER.error("-----> error while getting country by code {}", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse(ResponseMessages.INTERNAL_ERROR));
		}
	}

	/**
	 * method to construct country dto object from country object
	 * 
	 * @param country
	 * @return
	 */
	private CountryDTO constructCountryDTOfromCountry(Country country) {
		return new CountryDTO(country.getName(), country.getContinent(), country.getPopulation(),
				country.getLifeExpectancy(), country.getLanguages().get(0).getLanguage());
	}

}
