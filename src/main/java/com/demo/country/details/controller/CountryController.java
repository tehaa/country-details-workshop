package com.demo.country.details.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.country.details.dto.CountryDTO;
import com.demo.country.details.entity.Country;
import com.demo.country.details.service.CountryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/country")
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	public static final int COUNTRY_DETAILS_PAGE_NUMBER = 0;

	public static final int COUNTRY_DETAILS_PAGE_SIZE = 1;
	
	@Autowired
	private CountryService countryService;

	@ApiOperation(value = "This Api will get all countries in the world that registered in system ")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Page<Country>> getCountries(
			@RequestParam(required = false, defaultValue = "0", name = "pageIndex") Integer page,
			@RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer size) {
		LOGGER.debug("-----> start api get countries to get page number : {} which size : {} in countries", page, size);

		Pageable paging = PageRequest.of(page, size);
		return countryService.getCountries(paging);
	}

	@ApiOperation(value = "this Api will get the country details from the country code")
	@RequestMapping(value = "{countryCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> getCountry(@PathVariable String countryCode) {
		LOGGER.debug("-----> start get country with code : {} ", countryCode);
		
		//Pageable paging = PageRequest.of(COUNTRY_DETAILS_PAGE_NUMBER, COUNTRY_DETAILS_PAGE_SIZE);

		return countryService.getCountry(countryCode);
	}

}
