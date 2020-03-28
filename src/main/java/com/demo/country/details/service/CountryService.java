package com.demo.country.details.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import springfox.documentation.service.ResponseMessage;

@Service
public class CountryService {

	public static final int COUNTRY_DETAILS_PAGE_NUMBER = 0;

	public static final int COUNTRY_DETAILS_PAGE_SIZE = 1;

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
	public ResponseEntity<?> getCountry(String countryCode) {
		try {
			Pageable paging = PageRequest.of(COUNTRY_DETAILS_PAGE_NUMBER, COUNTRY_DETAILS_PAGE_SIZE);
			List<CountryDTO> countryDetailsList = countryRepo.getCountryFromCode(countryCode, paging);
			if (countryDetailsList.size() == 0) {
				LOGGER.error("-----> error while geeting country with code : {} country not found", countryCode);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(new MessageResponse(ResponseMessages.INVALID_COUNTRY_CODE));
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(countryDetailsList.get(0));
			}
		} catch (Exception e) {
			LOGGER.error("error while getting country by code {}", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse(ResponseMessages.INTERNAL_ERROR));
		}
	}

}
